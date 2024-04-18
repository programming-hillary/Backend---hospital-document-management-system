package org.mwashi_mwale.documents_service.repository;

import org.bson.types.ObjectId;
import org.mwashi_mwale.documents_service.model.DocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface DocumentRepository extends MongoRepository<DocumentModel, String> {
    public Mono<DocumentModel> findById(ObjectId id);
}
