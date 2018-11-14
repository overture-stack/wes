package bio.overture.wes.controller.api;

import bio.overture.wes.model.*;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Api(value = "runs", description = "the runs API")
public interface RunsApi {

  @ApiOperation(value = "Cancel a running workflow.", nickname = "cancelRun", notes = "", response = RunId.class, tags={ "WorkflowExecutionService", })
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "", response = RunId.class),
    @ApiResponse(code = 401, message = "The request is unauthorized.", response = ErrorResponse.class),
    @ApiResponse(code = 403, message = "The requester is not authorized to perform this action.", response = ErrorResponse.class),
    @ApiResponse(code = 404, message = "The requested workflow run wasn't found.", response = ErrorResponse.class),
    @ApiResponse(code = 500, message = "An unexpected error occurred.", response = ErrorResponse.class) })
  @RequestMapping(value = "/runs/{run_id}/cancel",
    produces = { "application/json" },
    consumes = { "application/json" },
    method = RequestMethod.POST)
  ResponseEntity<RunId> cancelRun(@ApiParam(value = "",required=true) @PathVariable("run_id") String runId);


  @ApiOperation(value = "Get detailed info about a workflow run.", nickname = "getRunLog", notes = "This endpoint provides detailed information about a given workflow run. The returned result has information about the outputs produced by this workflow (if available), a log object which allows the stderr and stdout to be retrieved, a log array so stderr/stdout for individual tasks can be retrieved, and the overall state of the workflow run (e.g. RUNNING, see the State section).", response = RunLog.class, tags={ "WorkflowExecutionService", })
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "", response = RunLog.class),
    @ApiResponse(code = 401, message = "The request is unauthorized.", response = ErrorResponse.class),
    @ApiResponse(code = 403, message = "The requester is not authorized to perform this action.", response = ErrorResponse.class),
    @ApiResponse(code = 404, message = "The requested workflow run not found.", response = ErrorResponse.class),
    @ApiResponse(code = 500, message = "An unexpected error occurred.", response = ErrorResponse.class) })
  @RequestMapping(value = "/runs/{run_id}",
    produces = { "application/json" },
    consumes = { "application/json" },
    method = RequestMethod.GET)
  ResponseEntity<RunLog> getRunLog(@ApiParam(value = "",required=true) @PathVariable("run_id") String runId);


  @ApiOperation(value = "Get quick status info about a workflow run.", nickname = "getRunStatus", notes = "This provides an abbreviated (and likely fast depending on implementation) status of the running workflow, returning a simple result with the  overall state of the workflow run (e.g. RUNNING, see the State section).", response = RunStatus.class, tags={ "WorkflowExecutionService", })
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "", response = RunStatus.class),
    @ApiResponse(code = 401, message = "The request is unauthorized.", response = ErrorResponse.class),
    @ApiResponse(code = 403, message = "The requester is not authorized to perform this action.", response = ErrorResponse.class),
    @ApiResponse(code = 404, message = "The requested workflow run wasn't found.", response = ErrorResponse.class),
    @ApiResponse(code = 500, message = "An unexpected error occurred.", response = ErrorResponse.class) })
  @RequestMapping(value = "/runs/{run_id}/status",
    produces = { "application/json" },
    consumes = { "application/json" },
    method = RequestMethod.GET)
  ResponseEntity<RunStatus> getRunStatus(@ApiParam(value = "",required=true) @PathVariable("run_id") String runId);


  @ApiOperation(value = "List the workflow runs.", nickname = "listRuns", notes = "This list should be provided in a stable ordering. (The actual ordering is implementation dependent.) When paging through the list, the client should not make assumptions about live updates, but should assume the contents of the list reflect the workflow list at the moment that the first page is requested.  To monitor a specific workflow run, use GetRunStatus or GetRunLog.", response = RunListResponse.class, tags={ "WorkflowExecutionService", })
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "", response = RunListResponse.class),
    @ApiResponse(code = 400, message = "The request is malformed.", response = ErrorResponse.class),
    @ApiResponse(code = 401, message = "The request is unauthorized.", response = ErrorResponse.class),
    @ApiResponse(code = 403, message = "The requester is not authorized to perform this action.", response = ErrorResponse.class),
    @ApiResponse(code = 500, message = "An unexpected error occurred.", response = ErrorResponse.class) })
  @RequestMapping(value = "/runs",
    produces = { "application/json" },
    method = RequestMethod.GET)
  ResponseEntity<RunListResponse> listRuns(@ApiParam(value = "OPTIONAL The preferred number of workflow runs to return in a page. If not provided, the implementation should use a default page size. The implementation must not return more items than `page_size`, but it may return fewer.  Clients should not assume that if fewer than `page_size` items are returned that all items have been returned.  The availability of additional pages is indicated by the value of `next_page_token` in the response.") @Valid @RequestParam(value = "page_size", required = false) Long pageSize, @ApiParam(value = "OPTIONAL Token to use to indicate where to start getting results. If unspecified, return the first page of results.") @Valid @RequestParam(value = "page_token", required = false) String pageToken);


  @ApiOperation(value = "Run a workflow.", nickname = "runWorkflow", notes = "This endpoint creates a new workflow run and returns a `RunId` to monitor its progress.  The `workflow_attachment` array may be used to upload files that are required to execute the workflow, including the primary workflow, tools imported by the workflow, other files referenced by the workflow, or files which are part of the input.  The implementation should stage these files to a temporary directory and execute the workflow from there. These parts must have a Content-Disposition header with a \"filename\" provided for each part.  Filenames may include subdirectories, but must not include references to parent directories with '..' -- implementations should guard against maliciously constructed filenames.  The `workflow_url` is either an absolute URL to a workflow file that is accessible by the WES endpoint, or a relative URL corresponding to one of the files attached using `workflow_attachment`.  The `workflow_params` JSON object specifies input parameters, such as input files.  The exact format of the JSON object depends on the conventions of the workflow language being used.  Input files should either be absolute URLs, or relative URLs corresponding to files uploaded using `workflow_attachment`.  The WES endpoint must understand and be able to access URLs supplied in the input.  This is implementation specific.  The `workflow_type` is the type of workflow language and must be \"CWL\" or \"WDL\" currently (or another alternative  supported by this WES instance).  The `workflow_type_version` is the version of the workflow language submitted and must be one supported by this WES instance.  See the `RunRequest` documentation for details about other fields.", response = RunId.class, tags={ "WorkflowExecutionService", })
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "", response = RunId.class),
    @ApiResponse(code = 400, message = "The request is malformed.", response = ErrorResponse.class),
    @ApiResponse(code = 401, message = "The request is unauthorized.", response = ErrorResponse.class),
    @ApiResponse(code = 403, message = "The requester is not authorized to perform this action.", response = ErrorResponse.class),
    @ApiResponse(code = 500, message = "An unexpected error occurred.", response = ErrorResponse.class) })
  @RequestMapping(value = "/runs",
    produces = { "application/json" },
    consumes = { "multipart/form-data" },
    method = RequestMethod.POST)
  ResponseEntity<RunId> runWorkflow(@ApiParam(value = "") @RequestParam(value="workflow_params", required=false)  String workflowParams,@ApiParam(value = "") @RequestParam(value="workflow_type", required=false)  String workflowType,@ApiParam(value = "") @RequestParam(value="workflow_type_version", required=false)  String workflowTypeVersion,@ApiParam(value = "") @RequestParam(value="tags", required=false)  String tags,@ApiParam(value = "") @RequestParam(value="workflow_engine_parameters", required=false)  String workflowEngineParameters,@ApiParam(value = "") @RequestParam(value="workflow_url", required=false)  String workflowUrl,@ApiParam(value = "") @RequestParam(value="workflow_attachment", required=false) List<byte[]> workflowAttachment);

}
