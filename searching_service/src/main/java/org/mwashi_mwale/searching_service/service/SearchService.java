package org.mwashi_mwale.searching_service.service;

import org.mwashi_mwale.searching_service.dto.SearchResponse;
import org.mwashi_mwale.searching_service.event.SearchEvent;
import org.mwashi_mwale.searching_service.model.Searchitems;
import org.mwashi_mwale.searching_service.dto.SearchItemsDTO;
import org.mwashi_mwale.searching_service.dto.SearchRequest;
import org.mwashi_mwale.searching_service.model.SearchModel;
import org.mwashi_mwale.searching_service.repository.SearchRepository;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SearchService {

    private final SearchRepository searchRepository;
    private final WebClient.Builder webClientBuilder;
    private final ObservationRegistry observationRegistry;
    private final ApplicationEventPublisher applicationEventPublisher;

    public String placeSearchModel(SearchRequest searchRequest) {
        SearchModel searchModel = new SearchModel();
        searchModel.setSearchIndex(UUID.randomUUID().toString());

        List<Searchitems> searchItem = searchRequest.getSearchItemsDTOS()
                .stream()
                .map(this::mapToDto)
                .toList();

        searchModel.setSearchitems(searchItem);

        List<LocalDateTime> dates = searchModel.getSearchitems().stream()
                .map(Searchitems::getDate)
                .toList();

        // Call Inventory Service, and place searchModel if product is in
        // stock
        Observation versionControlServiceObservation = Observation.createNotStarted("version-control-service-lookup",
                this.observationRegistry);
        versionControlServiceObservation.lowCardinalityKeyValue("call", "version_control_service");
        return versionControlServiceObservation.observe(() -> {
            SearchResponse[] versionControlResponseArray = webClientBuilder.build().get()
                    .uri("http://version_control_service/api/version_control_service",
                            uriBuilder -> uriBuilder.queryParam("date", dates).build())
                    .retrieve()
                    .bodyToMono(SearchResponse[].class)
                    .block();

            boolean allDocumentsAvailable = Arrays.stream(versionControlResponseArray)
                    .allMatch(SearchResponse::isAvailable);

            if (allDocumentsAvailable) {
                searchRepository.save(searchModel);
                // publish SearchModel Placed Event
                applicationEventPublisher.publishEvent(new SearchEvent(this, searchModel.getSearchIndex()));
                return "Search Placed";
            } else {
                throw new IllegalArgumentException("Document is not available, please try again later");
            }
        });

    }

    private Searchitems mapToDto(SearchItemsDTO searchItemDto) {
        Searchitems searchItem = new Searchitems();
        searchItem.setDate(searchItemDto.getDate());
        searchItem.setEditor(searchItemDto.getEditor());
        searchItem.setComment(searchItemDto.getComment());
        return searchItem;
    }
}
