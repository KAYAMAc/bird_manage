package com.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.main.entity.waterHistoryTbl;


public interface waterDao extends JpaRepository<waterHistoryTbl, Long> {
    
    @Query("SELECT u FROM User u WHERE u.start_date >= :startDate AND u.end_date <= :endDate")
    List<waterHistoryTbl> findRecordsByTimeRange(int startDate, int endDate);

    @Query("SELECT u FROM User u WHERE u.start_date >= :startDate AND u.end_date <= :endDate")
    void insertWaterHistory(waterHistoryTbl waterRecord);
}