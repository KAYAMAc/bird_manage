package main.java.com.main.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import main.java.com.main.entity.waterHistoryTbl;

/**
 * @author: zongcan.li
 * @create: 2024/04/02
 */

public interface waterDao extends JpaRepository<waterHistoryTbl, Long> {
    
     
    @Query("SELECT u FROM User u WHERE u.start_date >= :startDate AND u.end_date <= :endDate")
    List<waterHistoryTbl> findRecordsByTimeRange(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT u FROM User u WHERE u.start_date >= :startDate AND u.end_date <= :endDate")
    void insertWaterHistory(waterHistoryTbl waterRecord);
}