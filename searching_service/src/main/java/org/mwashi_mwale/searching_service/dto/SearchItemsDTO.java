package org.mwashi_mwale.searching_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchItemsDTO {
    private Long id;
    private String editor;
    private String comment;
    private LocalDateTime date;
}
