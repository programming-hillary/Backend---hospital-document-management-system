package org.mwashi_mwale.authenticator.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentDTO {
    private String name;
    private boolean authorization;
}
