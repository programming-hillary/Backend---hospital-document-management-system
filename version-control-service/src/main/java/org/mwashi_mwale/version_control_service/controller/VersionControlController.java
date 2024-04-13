package org.mwashi_mwale.version_control_service.controller;

import org.mwashi_mwale.version_control_service.dto.VersionControlDTO;
import org.mwashi_mwale.version_control_service.service.VersionControlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class VersionControlController {

    private final VersionControlService versionControlService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VersionControlDTO> isInStock(@RequestParam List<String> comment) {
        log.info("Received inventory check request for comment: {}", comment);
        return versionControlService.isAvailable(comment);
    }
}

