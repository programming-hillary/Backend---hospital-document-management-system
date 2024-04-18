package org.mwashi_mwale.searching_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "searches_doc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchModel {
    @Id
    private ObjectId id;
    private String searchIndex;
    private List<Searchitems> searchitems;
}
