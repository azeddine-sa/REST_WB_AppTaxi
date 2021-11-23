package be.azsa.apptaxi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "history_order")
public class HistoryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHistory;
    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    @OneToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
    @OneToOne
    @JoinColumn(name = "driver_id",nullable = false)
    private Driver driver;
}
