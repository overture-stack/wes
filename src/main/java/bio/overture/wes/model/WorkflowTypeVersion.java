package bio.overture.wes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

@ApiModel(description = "Available workflow types supported by a given instance of the service.")
@Validated
public class WorkflowTypeVersion {
  @JsonProperty("workflow_type_version")
  @Valid
  private List<String> workflowTypeVersion = null;

  public WorkflowTypeVersion workflowTypeVersion(List<String> workflowTypeVersion) {
    this.workflowTypeVersion = workflowTypeVersion;
    return this;
  }

  public WorkflowTypeVersion addWorkflowTypeVersionItem(String workflowTypeVersionItem) {
    if (this.workflowTypeVersion == null) {
      this.workflowTypeVersion = new ArrayList<String>();
    }
    this.workflowTypeVersion.add(workflowTypeVersionItem);
    return this;
  }

  /**
   * an array of one or more acceptable types for the `workflow_type`
   *
   * @return workflowTypeVersion
   */
  @ApiModelProperty(value = "an array of one or more acceptable types for the `workflow_type`")
  public List<String> getWorkflowTypeVersion() {
    return workflowTypeVersion;
  }

  public void setWorkflowTypeVersion(List<String> workflowTypeVersion) {
    this.workflowTypeVersion = workflowTypeVersion;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowTypeVersion workflowTypeVersion = (WorkflowTypeVersion) o;
    return Objects.equals(this.workflowTypeVersion, workflowTypeVersion.workflowTypeVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workflowTypeVersion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowTypeVersion {\n");

    sb.append("    workflowTypeVersion: ")
        .append(toIndentedString(workflowTypeVersion))
        .append("\n");
    sb.append("}");
    return sb.toString();
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
