package com.mastercard.billingrequestreport.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OfflineRequestCreate {

    @NotNull
    private String feederType;
    //public enum reportType  {Summary,Detail};
    @NotNull
    private String reportType;
    @NotNull
    private String searchCriteria;


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

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
}
