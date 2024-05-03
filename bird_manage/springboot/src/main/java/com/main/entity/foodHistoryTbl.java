package main.java.com.main.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Id;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "food_history")
public class foodHistoryTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    public Long foodHistoryId;

    @Column(name = "category")
    public String category;

    @Column(name = "portion")
    public Float portion;

    @Column(name = "time_stamp")
    public String timeStamp;

    @Column(name = "operator")
    public String operator;

    // Getters and setters
}
