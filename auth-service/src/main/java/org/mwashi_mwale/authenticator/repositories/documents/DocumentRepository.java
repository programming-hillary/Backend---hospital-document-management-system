package org.mwashi_mwale.authenticator.repositories.documents;

import org.mwashi_mwale.authenticator.data.documents.DocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends MongoRepository<DocumentModel, String> {
}
