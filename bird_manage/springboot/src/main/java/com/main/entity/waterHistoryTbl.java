package main.java.com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * @author: zongcan.li
 * @create: 2024/04/02
 */

@Data
@Entity
@Table(name = "water")
public class waterHistoryTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long waterHistoryId;

    @Column(name = "time_stamp")
    public LocalDateTime timeStamp;

    @Column(name = "operator")
    public String operator;

    // Getters and setters
}
