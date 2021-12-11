package be.azsa.apptaxi.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOrder;
    @Column(name = "departure", nullable = false)
    private String departure;
    @Column(name = "arrival", nullable = false)
    private String arrival;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "informations")
    private String infos;
    //@Enumerated(EnumType.STRING)
    //private Status status;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;
    /*
    public enum Status{
        SENT, IN_PROGRESS, DONE, CANCELED;
    }
     */

    public Order(){}

    public Order(long idOrder, String departure, String arrival, User user) {
        Timestamp tt = new Timestamp(System.currentTimeMillis());
        this.idOrder = idOrder;
        this.departure = departure;
        this.arrival = arrival;
        this.datetime = tt;
        this.user = user;
    }
}
