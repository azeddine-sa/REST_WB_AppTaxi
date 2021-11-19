package be.azsa.apptaxi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;
}
