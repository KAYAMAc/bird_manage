package main.java.com.main.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.java.com.main.entity.foodHistoryTbl;


@Repository
public interface foodDao extends JpaRepository<foodHistoryTbl, Long> {

    @Query("SELECT u FROM food_history u WHERE u.start_date >= :startDate AND u.end_date <= :endDate")
    List<foodHistoryTbl> findRecordsByTimeRange(LocalDateTime startDate, LocalDateTime endDate);

    //@Query("insert into food_history (food_id, )")
    //void insertFoodHistory(foodHistoryTbl foodRecord);
}