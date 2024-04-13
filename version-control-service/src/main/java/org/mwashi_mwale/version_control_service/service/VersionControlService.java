package org.mwashi_mwale.version_control_service.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.mwashi_mwale.version_control_service.dto.VersionControlDTO;
import org.mwashi_mwale.version_control_service.repository.VersionControlRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VersionControlService {

    private final VersionControlRepository versionControlRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<VersionControlDTO> isAvailable(List<String> skuCode) {
        log.info("Checking Versions");
        return versionControlRepository.findByDate(LocalDateTime.now()).stream()
                .map(versionontrol ->
                        VersionControlDTO.builder()
                                .editor(versionontrol.getEditor())
                                .comment(versionontrol.getComment())
                                .date(versionontrol.getDate())
                                .build()
                ).toList();
    }
}
