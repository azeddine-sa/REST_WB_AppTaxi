package be.azsa.apptaxi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_history")
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}
