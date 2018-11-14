package bio.overture.wes.controller.api;

import bio.overture.wes.model.RunId;
import bio.overture.wes.model.RunListResponse;
import bio.overture.wes.model.RunLog;
import bio.overture.wes.model.RunStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class RunsApiController implements RunsApi {

  private static final Logger log = LoggerFactory.getLogger(RunsApiController.class);

  private final ObjectMapper objectMapper;

  private final HttpServletRequest request;

  @org.springframework.beans.factory.annotation.Autowired
  public RunsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
    this.objectMapper = objectMapper;
    this.request = request;
  }

  public ResponseEntity<RunId> cancelRun(@ApiParam(value = "",required=true) @PathVariable("run_id") String runId) {
    String accept = request.getHeader("Accept");
    if (accept != null && accept.contains("application/json")) {
      try {
        return new ResponseEntity<RunId>(objectMapper.readValue("{  \"run_id\" : \"run_id\"}", RunId.class), HttpStatus.NOT_IMPLEMENTED);
      } catch (IOException e) {
        log.error("Couldn't serialize response for content type application/json", e);
        return new ResponseEntity<RunId>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    return new ResponseEntity<RunId>(HttpStatus.NOT_IMPLEMENTED);
  }

  public ResponseEntity<RunLog> getRunLog(@ApiParam(value = "",required=true) @PathVariable("run_id") String runId) {
    String accept = request.getHeader("Accept");
    if (accept != null && accept.contains("application/json")) {
      try {
        return new ResponseEntity<RunLog>(objectMapper.readValue("{  \"outputs\" : \"{}\",  \"request\" : {    \"workflow_engine_parameters\" : {      \"key\" : \"workflow_engine_parameters\"    },    \"workflow_url\" : \"workflow_url\",    \"workflow_params\" : \"{}\",    \"workflow_type\" : \"workflow_type\",    \"workflow_type_version\" : \"workflow_type_version\",    \"tags\" : {      \"key\" : \"tags\"    }  },  \"run_id\" : \"run_id\",  \"run_log\" : {    \"start_time\" : \"start_time\",    \"stdout\" : \"stdout\",    \"name\" : \"name\",    \"end_time\" : \"end_time\",    \"exit_code\" : 0,    \"cmd\" : [ \"cmd\", \"cmd\" ],    \"stderr\" : \"stderr\"  },  \"state\" : { },  \"task_logs\" : [ {    \"start_time\" : \"start_time\",    \"stdout\" : \"stdout\",    \"name\" : \"name\",    \"end_time\" : \"end_time\",    \"exit_code\" : 0,    \"cmd\" : [ \"cmd\", \"cmd\" ],    \"stderr\" : \"stderr\"  }, {    \"start_time\" : \"start_time\",    \"stdout\" : \"stdout\",    \"name\" : \"name\",    \"end_time\" : \"end_time\",    \"exit_code\" : 0,    \"cmd\" : [ \"cmd\", \"cmd\" ],    \"stderr\" : \"stderr\"  } ]}", RunLog.class), HttpStatus.NOT_IMPLEMENTED);
      } catch (IOException e) {
        log.error("Couldn't serialize response for content type application/json", e);
        return new ResponseEntity<RunLog>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    return new ResponseEntity<RunLog>(HttpStatus.NOT_IMPLEMENTED);
  }

  public ResponseEntity<RunStatus> getRunStatus(@ApiParam(value = "",required=true) @PathVariable("run_id") String runId) {
    String accept = request.getHeader("Accept");
    if (accept != null && accept.contains("application/json")) {
      try {
        return new ResponseEntity<RunStatus>(objectMapper.readValue("{  \"run_id\" : \"run_id\",  \"state\" : { }}", RunStatus.class), HttpStatus.NOT_IMPLEMENTED);
      } catch (IOException e) {
        log.error("Couldn't serialize response for content type application/json", e);
        return new ResponseEntity<RunStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    return new ResponseEntity<RunStatus>(HttpStatus.NOT_IMPLEMENTED);
  }

  public ResponseEntity<RunListResponse> listRuns(@ApiParam(value = "OPTIONAL The preferred number of workflow runs to return in a page. If not provided, the implementation should use a default page size. The implementation must not return more items than `page_size`, but it may return fewer.  Clients should not assume that if fewer than `page_size` items are returned that all items have been returned.  The availability of additional pages is indicated by the value of `next_page_token` in the response.") @Valid @RequestParam(value = "page_size", required = false) Long pageSize, @ApiParam(value = "OPTIONAL Token to use to indicate where to start getting results. If unspecified, return the first page of results.") @Valid @RequestParam(value = "page_token", required = false) String pageToken) {
    String accept = request.getHeader("Accept");
    if (accept != null && accept.contains("application/json")) {
      try {
        return new ResponseEntity<RunListResponse>(objectMapper.readValue("{  \"next_page_token\" : \"next_page_token\",  \"runs\" : [ {    \"run_id\" : \"run_id\",    \"state\" : { }  }, {    \"run_id\" : \"run_id\",    \"state\" : { }  } ]}", RunListResponse.class), HttpStatus.NOT_IMPLEMENTED);
      } catch (IOException e) {
        log.error("Couldn't serialize response for content type application/json", e);
        return new ResponseEntity<RunListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    return new ResponseEntity<RunListResponse>(HttpStatus.NOT_IMPLEMENTED);
  }

  public ResponseEntity<RunId> runWorkflow(@ApiParam(value = "") @RequestParam(value="workflow_params", required=false)  String workflowParams, @ApiParam(value = "") @RequestParam(value="workflow_type", required=false)  String workflowType, @ApiParam(value = "") @RequestParam(value="workflow_type_version", required=false)  String workflowTypeVersion, @ApiParam(value = "") @RequestParam(value="tags", required=false)  String tags, @ApiParam(value = "") @RequestParam(value="workflow_engine_parameters", required=false)  String workflowEngineParameters, @ApiParam(value = "") @RequestParam(value="workflow_url", required=false)  String workflowUrl, @ApiParam(value = "") @RequestParam(value="workflow_attachment", required=false) List<byte[]> workflowAttachment) {
    String accept = request.getHeader("Accept");
    if (accept != null && accept.contains("application/json")) {
      try {
        return new ResponseEntity<RunId>(objectMapper.readValue("{  \"run_id\" : \"run_id\"}", RunId.class), HttpStatus.NOT_IMPLEMENTED);
      } catch (IOException e) {
        log.error("Couldn't serialize response for content type application/json", e);
        return new ResponseEntity<RunId>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    return new ResponseEntity<RunId>(HttpStatus.NOT_IMPLEMENTED);
  }

}
