package org.mwashi_mwale.authenticator.endpoints.patients;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.mwashi_mwale.authenticator.data.documents.PatientsModel;
import org.mwashi_mwale.authenticator.providers.patients.PatientsDeleteService;
import org.mwashi_mwale.authenticator.providers.patients.PatientsPostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/patients")
public class PatientPostDeleteMappings {

    private PatientsDeleteService patientsDeleteService;
    private PatientsPostService patientsPostService;

    @PostMapping("/add_patient")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PatientsModel> createPatient(@RequestBody PatientsModel patient) {
        return patientsPostService.savePatient(patient);
    }

    @DeleteMapping("/patient/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deletePatient(@PathVariable("id") ObjectId id) {
        return patientsDeleteService.deleteById(id);
    }

    @DeleteMapping("/patient")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllPatients() {
        return patientsDeleteService.deleteAll();
    }

}
