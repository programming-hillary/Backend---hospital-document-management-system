package org.mwashi_mwale.authenticator.exception_handlers;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super("Patient with id " + id + " was not found.");
    }
}
