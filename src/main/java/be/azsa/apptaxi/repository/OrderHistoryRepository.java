package be.azsa.apptaxi.repository;

import be.azsa.apptaxi.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
    List<OrderHistory> findByDriver(long idDriver);
    List<OrderHistory> findByCar(long idCar);
    List<OrderHistory> findByUser(long idUser);
}
