package org.mwashi_mwale.authenticator.providers.patients;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.mwashi_mwale.authenticator.data.documents.PatientsModel;
import org.mwashi_mwale.authenticator.data.documents.person.BMI;
import org.mwashi_mwale.authenticator.data.documents.person.MedicalHistory;
import org.mwashi_mwale.authenticator.repositories.patients.PatientPatchRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientsPatchService {

    private PatientPatchRepository patientPatchRepository;

    public Mono<PatientsModel> updatePatientBMI(PatientsModel patient, BMI bmi, ObjectId id) {
        return patientPatchRepository.findPatientsModelByBmi(bmi).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalPatient -> {
                    if (optionalPatient.isPresent()) {
                        patient.set_id(id);
                        return patientPatchRepository.save(patient);
                    }

                    return Mono.empty();
                });
    }

    public Mono<PatientsModel> updatePatientMedicalHistory(PatientsModel patient, MedicalHistory history, ObjectId id) {
        return patientPatchRepository.findPatientsModelByHistory(history).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalPatient -> {
                    if (optionalPatient.isPresent()) {
                        patient.set_id(id);
                        return patientPatchRepository.save(patient);
                    }

                    return Mono.empty();
                });
    }

    public Mono<PatientsModel> updateAllPatientPhone(PatientsModel patient, Integer phone, ObjectId id) {
        return patientPatchRepository.findPatientsModelByPhoneNumber(phone).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalPatient -> {
                    if (optionalPatient.isPresent()) {
                        patient.set_id(id);
                        return patientPatchRepository.save(patient);
                    }

                    return Mono.empty();
                });
    }

    public Mono<PatientsModel> updatePatientEmail(PatientsModel patient, String email, ObjectId id) {
        return patientPatchRepository.findPatientsModelByEmail(email).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalPatient -> {
                    if (optionalPatient.isPresent()) {
                        patient.set_id(id);
                        return patientPatchRepository.save(patient);
                    }

                    return Mono.empty();
                });
    }
}
