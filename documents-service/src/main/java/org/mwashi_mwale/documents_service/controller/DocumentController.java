package org.mwashi_mwale.documents_service.controller;

import org.mwashi_mwale.documents_service.dto.DocumentRequest;
import org.mwashi_mwale.documents_service.dto.DocumentResponse;
import org.mwashi_mwale.documents_service.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDocument(@RequestBody DocumentRequest documentRequest) {
        documentService.createDocument(documentRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DocumentResponse> getAllDocuments() {
        return documentService.getAllDocuments();
    }

}
