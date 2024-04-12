package org.mwashi_mwale.documents_service.util;

import lombok.RequiredArgsConstructor;
import org.mwashi_mwale.documents_service.model.DocumentModel;
import org.mwashi_mwale.documents_service.repository.DocumentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final DocumentRepository documentRepository;

    @Override
    public void run(String... args) throws Exception {
        if (documentRepository.count() < 1) {
            DocumentModel document = new DocumentModel();
            document.setName("Mwashi Mwale");
            document.setDescription("This is displayed when there is no document in the database");
            document.setCategory("Developer's Document");
            document.setFormat("PDF");
            document.setBuilder_category("Developer");

            documentRepository.save(document);
        }
    }
}
