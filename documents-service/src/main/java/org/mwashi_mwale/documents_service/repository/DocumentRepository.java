package org.mwashi_mwale.documents_service.repository;

import org.mwashi_mwale.documents_service.model.DocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<DocumentModel, String> {
}
