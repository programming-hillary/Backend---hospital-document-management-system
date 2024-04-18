package org.mwashi_mwale.searching_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(value = "searchItems_doc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Searchitems {
    private ObjectId id;
    private String editor;
    private String comment;
    private LocalDateTime date;
}
