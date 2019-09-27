package com.mastercard.billingrequestreport.service;

import com.mastercard.billingrequestreport.Entity.OfflineRequest;
import com.mastercard.billingrequestreport.model.OfflineDetailsResponse;
import com.mastercard.billingrequestreport.model.OfflineRequestCreate;
import com.mastercard.billingrequestreport.model.OfflineRequestCreateResponse;
import com.mastercard.billingrequestreport.repository.BillingReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class BillingReportRequestService {

@Autowired
BillingReportRepository billingReportRepository;
@Autowired
    OfflineRequest offlineRequest;

    public OfflineRequestCreateResponse sendBillingReportRequest(String userId,OfflineRequestCreate offlineRequestCreate) {

        //Populate offline request details
        offlineRequest.setFeederType(offlineRequestCreate.getFeederType());
        offlineRequest.setReportType(offlineRequestCreate.getReportType());
        offlineRequest.setSearchCriteria(offlineRequestCreate.getSearchCriteria());
        offlineRequest.setUserId(userId);
        offlineRequest.setPath("mastercard.com");
        offlineRequest.setStatus("INITIATED");

        int i = billingReportRepository.insert(offlineRequest);

String message = null;
        if (i>0) {
            message= "Successfully created the offline request";
        } else{
            message= "We are unable to process your request ,please contact administrator";
    }
    return new OfflineRequestCreateResponse(message,"1234");
    }

public OfflineDetailsResponse getReportRequestDetailsById (String requestId) throws SQLException {

    OfflineDetailsResponse offlineDetailsResponse = new OfflineDetailsResponse();

    offlineRequest = billingReportRepository.findByRequestId(requestId);
    offlineDetailsResponse.setRequestId("1234");
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
