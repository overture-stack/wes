package bio.overture.wes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@ApiModel(description = "An object that can optionally include information about the error.")
@Validated
public class ErrorResponse   {
  @JsonProperty("msg")
  private String msg = null;

  @JsonProperty("status_code")
  private Integer statusCode = null;

  public ErrorResponse msg(String msg) {
    this.msg = msg;
    return this;
  }

  /**
   * A detailed error message.
   * @return msg
   **/
  @ApiModelProperty(value = "A detailed error message.")


  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public ErrorResponse statusCode(Integer statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * The integer representing the HTTP status code (e.g. 200, 404).
   * @return statusCode
   **/
  @ApiModelProperty(value = "The integer representing the HTTP status code (e.g. 200, 404).")


  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.msg, errorResponse.msg) &&
      Objects.equals(this.statusCode, errorResponse.statusCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msg, statusCode);
  }

  @Override
  public String toString() {
    return "class ErrorResponse {\n" +
      "    msg: " + toIndentedString(msg) + "\n" +
      "    statusCode: " + toIndentedString(statusCode) + "\n" +
      "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


