package org.mwashi_mwale.documents_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DocumentModel {

    @Id
    private String id;
    private String name;
    private String description;
    private String format;
    private String category;
    private String builder_category;
}
