package com.mastercard.billingrequestreport.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


//(SerializationFeature.FAIL_ON_EMPTY_BEANS)
public class OfflineRequestDTO {

    @NotNull
    private String feederType;
    @NotNull
   // private enum  reportType {Summary,Detail};
    private String   reportType ;
    /*@NotNull
    private String invoiceDate;*/

    private SearchCriteria searchCriteria;

    public OfflineRequestDTO() {
    }


    public OfflineRequestDTO(@NotNull String feederType, @NotNull String reportType, SearchCriteria searchCriteria, String requestId, String userId, String createdIimestamp, String lastUpdatedTimestamp, String status, String path, String isDeleted) {
        this.feederType = feederType;
        this.reportType = reportType;
        this.searchCriteria = searchCriteria;
        this.requestId = requestId;
        this.userId = userId;
        this.createdIimestamp = createdIimestamp;
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
        this.status = status;
        this.path = path;
        this.isDeleted = isDeleted;
    }

    private String requestId;
    private String userId;
    private String createdIimestamp;
    private String lastUpdatedTimestamp;
    private String status;
    private String path;
    private String isDeleted;

    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public String getFeederType() {
        return feederType;
    }

    public void setFeederType(String feederType) {
        this.feederType = feederType;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

  /*  public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
*/
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreatedIimestamp() {
        return createdIimestamp;
    }

    public void setCreatedIimestamp(String createdIimestamp) {
        this.createdIimestamp = createdIimestamp;
    }

    public String getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    public void setLastUpdatedTimestamp(String lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }


    @Override
    public String toString() {
        return "OfflineRequestDTO{" +
                "requestId='" + requestId + '\'' +
                ", userId='" + userId + '\'' +
                ", createdIimestamp='" + createdIimestamp + '\'' +
                ", lastUpdatedTimestamp='" + lastUpdatedTimestamp + '\'' +
                ", status='" + status + '\'' +
                ", path='" + path + '\'' +
                ", isDeleted='" + isDeleted + '\'' +
                '}';
    }
}
