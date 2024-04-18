package org.mwashi_mwale.searching_service.repository;

import org.mwashi_mwale.searching_service.model.SearchModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends MongoRepository<SearchModel, Long> {
}
