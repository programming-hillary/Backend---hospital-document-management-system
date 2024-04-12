package org.mwashi_mwale.authenticator.exception_handlers;

public class PatientsNotFoundException extends RuntimeException {
    public PatientsNotFoundException(String id) {
        super("Patient with id " + id + " was not found.");
    }
}
