package org.mwashi_mwale.authenticator.providers.patients;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.mwashi_mwale.authenticator.repositories.patients.PatientRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PatientsDeleteService {

    private PatientRepository patientRepository;

    public Mono<Void> deleteById(ObjectId id) {
        return patientRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return patientRepository.deleteAll();
    }

}
