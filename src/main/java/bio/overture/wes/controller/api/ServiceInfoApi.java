package bio.overture.wes.controller.api;

import bio.overture.wes.model.api.ErrorResponse;
import bio.overture.wes.model.api.ServiceInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "service-info", description = "the service-info API")
public interface ServiceInfoApi {

  @ApiOperation(
      value = "Get information about Workflow Execution Service.",
      nickname = "getServiceInfo",
      notes =
          "May include information related (but not limited to) the workflow descriptor formats, versions supported, the WES API versions supported, and information about general service availability.",
      response = ServiceInfo.class,
      tags = {
        "WorkflowExecutionService",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "", response = ServiceInfo.class),
        @ApiResponse(
            code = 400,
            message = "The request is malformed.",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 401,
            message = "The request is unauthorized.",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 403,
            message = "The requester is not authorized to perform this action.",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 500,
            message = "An unexpected error occurred.",
            response = ErrorResponse.class)
      })
  @RequestMapping(
      value = "/service-info",
      produces = {"application/json"},
      consumes = {"application/json"},
      method = RequestMethod.GET)
  ResponseEntity<ServiceInfo> getServiceInfo();
}
