package com.main.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.main.entity.foodHistoryTbl;

public interface foodDao extends JpaRepository<foodHistoryTbl, Long> {

    @Query("SELECT u FROM food_history u WHERE u.start_date >= :startDate AND u.end_date <= :endDate")
    List<foodHistoryTbl> findRecordsByTimeRange(int startDate, int endDate);

    @Query("SELECT u FROM food_history u WHERE u.start_date >= :startDate AND u.end_date <= :endDate")
    void insertFoodHistory(foodHistoryTbl foodRecord);
}