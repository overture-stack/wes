package bio.overture.wes.model.entity;

import java.util.UUID;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "run")
@Data
public class Run {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID runId;

  @Column(name = "state", nullable = false, updatable = true)
  private String state;
}
