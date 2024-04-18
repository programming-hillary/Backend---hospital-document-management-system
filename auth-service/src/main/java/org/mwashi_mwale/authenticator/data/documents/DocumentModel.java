package org.mwashi_mwale.authenticator.data.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "documents_doc")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DocumentModel {

    @Id
    private String id;
    private String name;
    private boolean authorization;
}
