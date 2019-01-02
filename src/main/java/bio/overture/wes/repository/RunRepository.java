package bio.overture.wes.repository;

import bio.overture.wes.model.entity.Run;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunRepository extends JpaRepository<Run, UUID> {}
