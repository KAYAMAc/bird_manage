package com.main.entiry;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "water_history")
public class waterHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long waterHistoryId;

    @Column(name = "time_stamp")
    private Timestamp timeStamp;

    @Column(name = "operator")
    private String operator;

    // Getters and setters
}
