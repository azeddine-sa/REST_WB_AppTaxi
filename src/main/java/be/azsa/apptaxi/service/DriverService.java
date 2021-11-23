package be.azsa.apptaxi.service;

import be.azsa.apptaxi.model.Driver;
import be.azsa.apptaxi.model.User;

import java.util.List;

public interface DriverService {
    Driver saveDriver(Driver driver);
    List<Driver> getAllDrivers();
    Driver getDriverById(long id);
    Driver getDriverByDriverNum(int driverNum);
    Driver updateDriver(Driver driver, long id);
    void deleteDriver(long id);
}
