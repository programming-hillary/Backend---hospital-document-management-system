package org.mwashi_mwale.authenticator.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginRequest {
    @MongoId
    private ObjectId id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;
    private List<String> roles;
    private boolean isActive;
}
