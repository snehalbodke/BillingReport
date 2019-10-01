package com.mastercard.billingrequestreport.repository;

import com.mastercard.billingrequestreport.Entity.OfflineRequest;
import com.mastercard.billingrequestreport.model.OfflineDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Repository
public class BillingReportRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(OfflineRequest offlineRequest) {
        String dateStr = getDate();
        return jdbcTemplate.update("insert into OFFLINE_REQUESTS (REQUEST_ID,USER_ID, CREATED_TIMESTAMP, LAST_UPDATED_TIMESTAMP,STATUS,PATH,IS_DELETED,FEEDER_TYPE,SEARCH_CRITERIA,REPORT_TYPE) " + "values(?,?,  ?, ?,?,  ?, ?,?,?,?)",
                new Object[]{
                        offlineRequest.getRequestId(),   offlineRequest.getUserId(), dateStr, dateStr, offlineRequest.getStatus(), offlineRequest.getPath(), offlineRequest.getIsDeleted(), offlineRequest.getFeederType(), offlineRequest.getSearchCriteria(), offlineRequest.getReportType()
                });
    }

    public OfflineRequest findByRequestId(String id) throws SQLException {
        String sql = "SELECT * FROM OFFLINE_REQUESTS WHERE REQUEST_ID = ?";

     return (OfflineRequest) jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper(OfflineRequest.class));

    }


    public String getDate() {

        LocalDateTime current = LocalDateTime.now();
        System.out.println("current date and time : " +
                current);
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formatedDateTime = current.format(format);
        System.out.println("formatedDateTime :" + formatedDateTime);

        return formatedDateTime;

    }


}
