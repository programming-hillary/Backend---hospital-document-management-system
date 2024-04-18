package org.mwashi_mwale.authenticator.repositories.patients;

import org.bson.types.ObjectId;
import org.mwashi_mwale.authenticator.data.documents.PatientsModel;
import org.mwashi_mwale.authenticator.data.documents.person.BMI;
import org.mwashi_mwale.authenticator.data.documents.person.MedicalHistory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PatientPatchRepository extends ReactiveMongoRepository<PatientsModel, ObjectId> {
    public Mono<PatientsModel> findPatientsModelByBmi(BMI bmi);
    public Mono<PatientsModel> findPatientsModelByHistory(MedicalHistory history);
    public Mono<PatientsModel> findPatientsModelByEmail(String email);

    public Mono<PatientsModel> findPatientsModelByPhoneNumber(Integer phoneNumber);

}
