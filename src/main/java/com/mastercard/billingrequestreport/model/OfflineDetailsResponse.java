package com.mastercard.billingrequestreport.model;


import lombok.Data;

@Data
public class OfflineDetailsResponse {


 /*       private String requestId;
        private String userId;
        private String createdTimestamp;
        private String lastUpdatedTimestamp;
        private String status;
        private String path;
        private String isDeleted;
        private String feederType;
        private String reportType ;
        private String searchCriteria;*/

        private String requestId;
        private String requestedTimeStamp;
        private String status;
        private String link;


        public String getRequestId() {
                return requestId;
        }

        public void setRequestId(String requestId) {
                this.requestId = requestId;
        }

        public String getRequestedTimeStamp() {
                return requestedTimeStamp;
        }

        public void setRequestedTimeStamp(String requestedTimeStamp) {
                this.requestedTimeStamp = requestedTimeStamp;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getLink() {
                return link;
        }

        public void setLink(String link) {
                this.link = link;
        }
}
