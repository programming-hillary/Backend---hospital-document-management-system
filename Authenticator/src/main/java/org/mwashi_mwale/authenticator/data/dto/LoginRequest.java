package org.mwashi_mwale.authenticator.data.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank String username,
                           @NotBlank String password) {
}
