package org.mwashi_mwale.authenticator.repositories.patients;

import org.bson.types.ObjectId;
import org.mwashi_mwale.authenticator.data.documents.PatientsModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends ReactiveMongoRepository<PatientsModel, ObjectId> {
}
