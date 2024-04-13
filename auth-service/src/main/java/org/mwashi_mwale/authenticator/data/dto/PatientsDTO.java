package org.mwashi_mwale.authenticator.data.dto;

import org.bson.types.ObjectId;
import org.mwashi_mwale.authenticator.data.documents.person.Address;
import org.mwashi_mwale.authenticator.data.documents.person.MedicalHistory;
import org.mwashi_mwale.authenticator.data.documents.person.Name;

import java.util.List;

public record PatientsDTO(
        ObjectId _id,
        List<Name> name,
        Address address,
        String email,
        String countryCode,
        MedicalHistory history
) {}
