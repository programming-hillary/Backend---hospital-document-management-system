package org.mwashi_mwale.document_deletion_service.controller;

import org.mwashi_mwale.document_deletion_service.model.DocumentModel;
import org.mwashi_mwale.document_deletion_service.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteDocument(@PathVariable("id") Long id, @RequestBody DocumentModel documentRequest) {
        documentService.deleteDocument(documentRequest);
    }
}
