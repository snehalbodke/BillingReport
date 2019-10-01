package com.mastercard.billingrequestreport.service;

import com.mastercard.billingrequestreport.Entity.OfflineRequest;
import com.mastercard.billingrequestreport.model.OfflineDetailsResponse;
import com.mastercard.billingrequestreport.model.OfflineRequestCreate;
import com.mastercard.billingrequestreport.model.OfflineRequestCreateResponse;
import com.mastercard.billingrequestreport.repository.BillingReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BillingReportRequestService {

@Autowired
BillingReportRepository billingReportRepository;
@Autowired
    OfflineRequest offlineRequest;

AtomicLong reqId = new AtomicLong(0);

    public OfflineRequestCreateResponse sendBillingReportRequest(String userId,OfflineRequestCreate offlineRequestCreate) {

        //Populate offline request details
        offlineRequest.setRequestId(String.valueOf(reqId.incrementAndGet()));
        offlineRequest.setFeederType(offlineRequestCreate.getFeederType());
        offlineRequest.setReportType(offlineRequestCreate.getReportType().toString());
        offlineRequest.setSearchCriteria(offlineRequestCreate.getSearchCriteria());
        offlineRequest.setUserId(userId);
        offlineRequest.setPath(offlineRequest.getRequestId() +"/download");
        offlineRequest.setStatus("INITIATED");
        offlineRequest.setIsDeleted("N");

        int i = billingReportRepository.insert(offlineRequest);

        String message = null;
        if (i>0) {
            message= "Successfully created the offline request";
        } else{
            message= "We are unable to process your request ,please contact administrator";
    }
    return new OfflineRequestCreateResponse(message,offlineRequest.getRequestId());
    }

public OfflineDetailsResponse getReportRequestDetailsById (String requestId) throws SQLException {

    OfflineDetailsResponse offlineDetailsResponse = new OfflineDetailsResponse();

    offlineRequest = billingReportRepository.findByRequestId(requestId);
    offlineDetailsResponse.setRequestId(requestId);
    offlineDetailsResponse.setStatus(offlineRequest.getStatus());
    offlineDetailsResponse.setLink(offlineRequest.getPath());
    offlineDetailsResponse.setRequestedTimeStamp(offlineRequest.getCreatedTimestamp());

   return offlineDetailsResponse ;
}

//To download Files from S3
    public Object downloadReportById (String requestId) throws SQLException {
        return  new Object();
    }
}
