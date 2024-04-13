package org.mwashi_mwale.authenticator.data.dto.person;

public record PersonNameDTO(
        String firstName,
        String lastName,
        String otherName,
        String surName
) {
}
