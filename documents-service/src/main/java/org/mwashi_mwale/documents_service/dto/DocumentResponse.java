package org.mwashi_mwale.documents_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentResponse {
    private String id;
    private String name;
    private String description;
    private String format;
    private String category;
    private String builder_category;
}
