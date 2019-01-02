package bio.overture.wes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

public class RunId {
  @JsonProperty("run_id")
  private String runId = null;

  public RunId runId(String runId) {
    this.runId = runId;
    return this;
  }

  /**
   * workflow run ID
   *
   * @return runId
   */
  @ApiModelProperty(value = "workflow run ID")
  public String getRunId() {
    return runId;
  }

  public void setRunId(String runId) {
    this.runId = runId;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RunId runId = (RunId) o;
    return Objects.equals(this.runId, runId.runId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(runId);
  }

  @Override
  public String toString() {
    return "class RunId {\n" + "    runId: " + toIndentedString(runId) + "\n" + "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
