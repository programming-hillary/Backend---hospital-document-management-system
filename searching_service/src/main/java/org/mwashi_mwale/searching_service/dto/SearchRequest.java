package org.mwashi_mwale.searching_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    private List<SearchItemsDTO> searchItemsDTOS;
}
