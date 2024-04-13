package org.mwashi_mwale.searching_service.controller;

import org.mwashi_mwale.searching_service.dto.SearchRequest;
import org.mwashi_mwale.searching_service.service.SearchService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class SearchController {

    private final SearchService searchService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "version-control", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "version-control")
    @Retry(name = "version-control")
    public CompletableFuture<String> makeSearch(@RequestBody SearchRequest searchRequest) {
        log.info("Searching");
        return CompletableFuture.supplyAsync(() -> searchService.makeSearch(searchRequest));
    }

    public CompletableFuture<String> fallbackMethod(SearchRequest searchRequest, RuntimeException runtimeException) {
        log.info("Cannot Search. Executing Fallback logic");
        return CompletableFuture.supplyAsync(() -> "Oops! Something went wrong, search after some time!");
    }
}
