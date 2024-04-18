package org.mwashi_mwale.version_control_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;

@Document(value = "versions_doc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VersionControlModel {
    @Id
    private ObjectId id;
    private String editor;
    private String comment;
    private LocalDateTime date;
}
