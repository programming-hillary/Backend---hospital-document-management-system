package org.mwashi_mwale.authenticator.repositories;

import org.mwashi_mwale.authenticator.data.dto.LoginRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface LoginRepository extends MongoRepository<LoginRequest, Long> {

    public Mono<LoginRequest> findByUsername(String userName);
}
