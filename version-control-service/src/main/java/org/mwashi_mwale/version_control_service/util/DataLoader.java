package org.mwashi_mwale.version_control_service.util;

import org.mwashi_mwale.version_control_service.model.VersionControlModel;
import lombok.RequiredArgsConstructor;
import org.mwashi_mwale.version_control_service.repository.VersionControlRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final VersionControlRepository versionControlRepository;
    @Override
    public void run(String... args) throws Exception {
        VersionControlModel versionControlModel = new VersionControlModel();
        versionControlModel.setDate(LocalDateTime.now());
        versionControlModel.setComment("Document 1");

        VersionControlModel versionControlModel1 = new VersionControlModel();
        versionControlModel.setDate(LocalDateTime.now());
        versionControlModel.setComment("Document 2");

        versionControlRepository.save(versionControlModel);
        versionControlRepository.save(versionControlModel1);
    }
}
