package org.mwashi_mwale.version_control_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VersionControlDTO {
    private boolean isAvailable;
    private String editor;
    private String comment;
    private LocalDateTime date;
}
