package org.mwashi_mwale.documents_service.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.mwashi_mwale.documents_service.dto.DocumentRequest;
import org.mwashi_mwale.documents_service.dto.DocumentResponse;
import org.mwashi_mwale.documents_service.model.DocumentModel;
import org.mwashi_mwale.documents_service.service.DocumentService;
import org.mwashi_mwale.documents_service.service.FileStorageService;
import org.mwashi_mwale.documents_service.service.Response;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
@Slf4j
public class DocumentController {

    private final DocumentService documentService;
    private FileStorageService fileStorageService;

    @PostMapping("/uploadFile")
    @ResponseStatus(HttpStatus.CREATED)
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new Response(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    @ResponseStatus(HttpStatus.CREATED)
    public List < Response > uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }



    @GetMapping("/downloadFile/{fileName:.+}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity < Resource > downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            log.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<DocumentResponse> getAllDocuments() {
        return documentService.getAllDocuments();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DocumentModel> getOneDocument(@PathVariable ObjectId id) {
        return documentService.getDocumentById(id);
    }

}
