package com.mastercard.billingrequestreport.controller;

import com.mastercard.billingrequestreport.exception.model.ErrorHandler;
import com.mastercard.billingrequestreport.model.OfflineDetailsResponse;
import com.mastercard.billingrequestreport.model.OfflineRequestCreate;
import com.mastercard.billingrequestreport.model.OfflineRequestCreateResponse;
import com.mastercard.billingrequestreport.service.BillingReportRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@RestController
@RequestMapping("/tran-detail/requests")
@Api("Requets API endpoints for posting ,retrieving and updating offline request of users from system.")
public class OfflineRequestController {

    @Autowired
    private BillingReportRequestService billingReportRequestService;

    @PostMapping()
    @ApiOperation("Returns Request Id and message post submittting the request for offline processing.")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request", response = ErrorHandler.class),
            @ApiResponse(code = 404, message = "Record Not Found", response = ErrorHandler.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorHandler.class )
            
    })
    public ResponseEntity<OfflineRequestCreateResponse> requestReport(@RequestBody @Valid OfflineRequestCreate offlineRequestCreate,@RequestHeader("userId") String userId) {


       return new ResponseEntity<OfflineRequestCreateResponse>(billingReportRequestService.sendBillingReportRequest(userId,offlineRequestCreate), HttpStatus.CREATED);


    }

    @ApiOperation("Returns Offline request details for {request-id} .")
    @GetMapping("/{request-id}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request", response = ErrorHandler.class),
            @ApiResponse(code = 404, message = "Record Not Found", response = ErrorHandler.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorHandler.class )
            
    })
    public ResponseEntity<OfflineDetailsResponse> getReportRequestDetailsById(@PathVariable(value = "request-id") String requestId) throws SQLException {
        OfflineDetailsResponse offlineDetailsResponse = billingReportRequestService.getReportRequestDetailsById(requestId);
        return ResponseEntity.ok().body(offlineDetailsResponse);
    }

    @ApiOperation("Downloads offline details as per file generated for {request-id}.")
    @GetMapping("{request-id}/download")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request", response = ErrorHandler.class),
            @ApiResponse(code = 404, message = "Record Not Found", response = ErrorHandler.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorHandler.class )
            
    })
    public ResponseEntity<Object> downloadReportById(@PathVariable(value = "request-id") String requestId) throws SQLException {
        return ResponseEntity.ok().body(billingReportRequestService.downloadReportById(requestId));
    }



}
