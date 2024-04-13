package org.mwashi_mwale.searching_service.repository;

import org.mwashi_mwale.searching_service.model.SearchModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<SearchModel, Long> {
}
