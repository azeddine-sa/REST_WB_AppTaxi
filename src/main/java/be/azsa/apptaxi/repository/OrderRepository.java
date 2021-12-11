package be.azsa.apptaxi.repository;

import be.azsa.apptaxi.model.Order;
import be.azsa.apptaxi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    Optional<Order> findByDatetime(Date datetime);
    List<Order> findByUser(User user);
}
