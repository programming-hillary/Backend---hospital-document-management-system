package org.mwashi_mwale.authenticator.endpoints.documents;

import org.mwashi_mwale.authenticator.data.dto.DocumentDTO;
import org.mwashi_mwale.authenticator.providers.documents.DocumentService;
import org.mwashi_mwale.authenticator.data.documents.DocumentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/document")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteDocument(@PathVariable("id") Long id, @RequestBody DocumentDTO documentDTO) {
        documentService.deleteDocument(documentDTO);
    }
}
