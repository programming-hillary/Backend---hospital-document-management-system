package org.mwashi_mwale.authenticator.providers.patients;

import lombok.RequiredArgsConstructor;
import org.mwashi_mwale.authenticator.data.documents.PatientsModel;
import org.mwashi_mwale.authenticator.repositories.patients.PatientRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PatientsPostService {

    private PatientRepository patientRepository;

    public Mono<PatientsModel> savePatient(PatientsModel patient) {
        return patientRepository.save(patient);
    }
}
