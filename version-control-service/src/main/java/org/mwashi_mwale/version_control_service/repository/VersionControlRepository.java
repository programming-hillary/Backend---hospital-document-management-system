package org.mwashi_mwale.version_control_service.repository;

import org.mwashi_mwale.version_control_service.model.VersionControlModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface VersionControlRepository extends MongoRepository<VersionControlModel, Long> {
    List<VersionControlModel> findByDate(LocalDateTime date);
}
