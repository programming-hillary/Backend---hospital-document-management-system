/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mwashi_mwale.authenticator.repositories.doctors;


import org.bson.types.ObjectId;
import org.mwashi_mwale.authenticator.data.documents.Doctor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface DoctorRepository extends ReactiveMongoRepository<Doctor, ObjectId> {

    public Mono<Doctor> findByUsername(String username);

}
