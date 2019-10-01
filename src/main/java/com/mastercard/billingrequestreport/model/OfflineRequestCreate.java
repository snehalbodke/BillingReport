package com.mastercard.billingrequestreport.model;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OfflineRequestCreate {

    public enum ReportType {
        Summary,Detail;
    }
    @NotNull
    private String feederType;
    private ReportType reportType;

    @NotNull
    private String searchCriteria;

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public String getFeederType() {
        return feederType;
    }

    public void setFeederType(String feederType) {
        this.feederType = feederType;
    }

   /* public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }*/

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
}
