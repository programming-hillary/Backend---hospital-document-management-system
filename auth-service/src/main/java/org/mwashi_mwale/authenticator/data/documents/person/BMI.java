package org.mwashi_mwale.authenticator.data.documents.person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BMI {
    private Integer weight;
    private Integer height;
}
