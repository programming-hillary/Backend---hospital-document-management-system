package org.mwashi_mwale.authenticator.exception_handlers;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String id) {
        super("Patient with id " + id + " was not found.");
    }
}
