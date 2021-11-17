package be.azsa.apptaxi.service;

import be.azsa.apptaxi.model.Driver;

import java.util.List;

public interface DriverService {
    Driver saveDriver(Driver driver);
    List<Driver> getAllDrivers();
    Driver getDriverById(long id);
    Driver updateDriver(Driver driver, long id);
    void deleteDriver(long id);
}
