package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "water_history")
public class waterHistoryTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long waterHistoryId;

    @Column(name = "time_stamp")
    public String timeStamp;

    @Column(name = "operator")
    public String operator;

    // Getters and setters
}
