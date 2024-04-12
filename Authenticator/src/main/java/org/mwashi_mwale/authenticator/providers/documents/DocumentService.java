package org.mwashi_mwale.authenticator.providers.documents;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mwashi_mwale.document_deletion_service.dto.DocumentRequest;
import org.mwashi_mwale.document_deletion_service.dto.DocumentResponse;
import org.mwashi_mwale.authenticator.data.documents.DocumentModel;
import org.mwashi_mwale.authenticator.repositories.documents.DocumentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentService {

    private final DocumentRepository documentRepository;

    public void deleteDocument(DocumentModel documentRequest) {
        DocumentModel documentModel = DocumentModel.builder()
                .name(documentRequest.getName())
                .build();

        documentRepository.save(documentModel);
        log.info("Document {} is saved", documentModel.getId());
    }

}
