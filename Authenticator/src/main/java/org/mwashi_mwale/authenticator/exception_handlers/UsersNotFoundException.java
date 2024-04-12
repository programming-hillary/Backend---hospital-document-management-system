package org.mwashi_mwale.authenticator.exception_handlers;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(String id) {
        super("Patient with id " + id + " was not found.");
    }
}
