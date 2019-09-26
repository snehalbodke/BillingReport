package com.mastercard.billingrequestreport.model;


import lombok.Data;

@Data

public class OfflineRequestCreateResponse {
    private String message;
    private String reuestId;

    public OfflineRequestCreateResponse(String message, String reuestId) {
        this.message = message;
        this.reuestId = reuestId;
    }
}
