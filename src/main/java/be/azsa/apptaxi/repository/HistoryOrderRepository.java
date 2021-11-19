package be.azsa.apptaxi.repository;

import be.azsa.apptaxi.model.HistoryOrder;
import be.azsa.apptaxi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryOrderRepository extends JpaRepository<HistoryOrder, Long> {
    List<HistoryOrder> findByDriver(long idDriver);
    List<HistoryOrder> findByCar(long idCar);
}
