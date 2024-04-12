package org.mwashi_mwale.authenticator.data.documents;


import org.mwashi_mwale.authenticator.data.documents.person.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.mwashi_mwale.authenticator.data.documents.person.Address;
import org.mwashi_mwale.authenticator.data.documents.person.BMI;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Builder
@Document(collection = "patients")
@AllArgsConstructor
@NoArgsConstructor
public class PatientsModel {
    @MongoId
    @Indexed(unique = true)
    private ObjectId _id;

    @Indexed(unique = true)
    private List<Name> name;
    private Address address;

    @Indexed(unique = true)
    private String email;
    private String countryCode;
    private Integer phoneNumber;
    private MedicalHistory history;
    private BMI bmi;

}
