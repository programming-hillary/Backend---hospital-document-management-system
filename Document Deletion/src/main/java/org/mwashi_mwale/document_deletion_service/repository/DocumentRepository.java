package org.mwashi_mwale.document_deletion_service.repository;

import org.mwashi_mwale.document_deletion_service.model.DocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<DocumentModel, String> {
}
