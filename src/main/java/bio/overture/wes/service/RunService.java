package bio.overture.wes.service;

import bio.overture.wes.model.entity.Run;
import bio.overture.wes.repository.RunRepository;
import java.util.UUID;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunService {

  private final RunRepository runRepository;

  @Autowired
  public RunService(RunRepository runRepository) {
    this.runRepository = runRepository;
  }

  public UUID create() {
    val run = new Run();
    run.setState("unknown");
    return runRepository.save(run).getRunId();
  }
}
