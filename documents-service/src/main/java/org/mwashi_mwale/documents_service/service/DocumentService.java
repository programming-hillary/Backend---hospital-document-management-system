package org.mwashi_mwale.documents_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mwashi_mwale.documents_service.dto.DocumentRequest;
import org.mwashi_mwale.documents_service.dto.DocumentResponse;
import org.mwashi_mwale.documents_service.model.DocumentModel;
import org.mwashi_mwale.documents_service.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentService {

    private final DocumentRepository documentRepository;

    public void createDocument(DocumentRequest documentRequest) {
        DocumentModel documentModel = DocumentModel.builder()
                .name(documentRequest.getName())
                .description(documentRequest.getDescription())
                .category(documentRequest.getCategory())
                .format(documentRequest.getFormat())
                .builder_category(documentRequest.getBuilder_category())
                .build();

        documentRepository.save(documentModel);
        log.info("Document {} is saved", documentModel.getId());
    }

    public List<DocumentResponse> getAllDocuments() {
        List<DocumentModel> documents = documentRepository.findAll();

        return documents.stream().map(this::mapToDocumentResponse).toList();
    }

    private DocumentResponse mapToDocumentResponse(DocumentModel document) {
        return DocumentResponse.builder()
                .id(document.getId())
                .name(document.getName())
                .description(document.getDescription())
                .category(document.getCategory())
                .format(document.getFormat())
                .builder_category(document.getBuilder_category())
                .build();
    }
}
