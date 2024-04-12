package org.mwashi_mwale.authenticator.providers.patients;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.mwashi_mwale.authenticator.data.documents.PatientsModel;
import org.mwashi_mwale.authenticator.repositories.patients.PatientRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientsPutService {

    private PatientRepository patientRepository;

    public Mono<PatientsModel> updateSpecificPatient(PatientsModel patient, ObjectId id) {
        return patientRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalPatient -> {
                    if (optionalPatient.isPresent()) {
                        patient.set_id(id);
                        return patientRepository.save(patient);
                    }

                    return Mono.empty();
                });
    }
}
