package be.azsa.apptaxi.repository;

import be.azsa.apptaxi.model.Driver;
import be.azsa.apptaxi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByDriverNum(int driverNum);
}
