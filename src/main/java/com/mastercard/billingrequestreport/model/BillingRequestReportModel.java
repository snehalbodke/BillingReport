package com.mastercard.billingrequestreport.model;

import javax.validation.constraints.NotNull;


public class BillingRequestReportModel {
    @NotNull
    private String feederType;
    @NotNull
    private enum  reportType {Summary,Detail};
    @NotNull
    private String invoiceDate;


    public String getFeederType() {
        return feederType;
    }

    public void setFeederType(String feederType) {
        this.feederType = feederType;
    }

   public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public String toString() {
        return "BillingRequestReportModel{" +
                "feederType='" + feederType + '\'' +
              //  ", reportType='" + reportType + '\'' +
                ", invoiceDate='" + invoiceDate + '\'' +
                '}';
    }
}
