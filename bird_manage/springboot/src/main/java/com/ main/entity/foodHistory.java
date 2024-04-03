package com.main.entiry;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "food_history")
public class foodHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodHistoryId;

    @Column(name = "category")
    private String category;

    @Column(name = "portion")
    private Float portion;

    @Column(name = "time_stamp")
    private Timestamp timeStamp;

    @Column(name = "operator")
    private String operator;

    // Getters and setters
}
