package org.mwashi_mwale.version_control_service.repository;

import org.mwashi_mwale.version_control_service.model.VersionControlModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface VersionControlRepository extends JpaRepository<VersionControlModel, Long> {
    List<VersionControlModel> findByDate(LocalDateTime date);
}
