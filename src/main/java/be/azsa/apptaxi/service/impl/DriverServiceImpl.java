package be.azsa.apptaxi.service.impl;

import be.azsa.apptaxi.exception.ResourceNotFoundException;
import be.azsa.apptaxi.model.Driver;
import be.azsa.apptaxi.model.User;
import be.azsa.apptaxi.repository.DriverRepository;
import be.azsa.apptaxi.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {
    private DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) { this.driverRepository = driverRepository; }


    @Override
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver getDriverById(long id) {
        Optional<Driver> driver = driverRepository.findById(id);
        if (driver.isPresent()){
            return driver.get();
        } else{
            throw new ResourceNotFoundException("Driver", "Id", id);
        }
        //return driverRepository.findById(id).orElseThrow(
        //        () -> new ResourceNotFoundException("Driver", "Id", id));
    }

    @Override
    public Driver getDriverByDriverNum(int driverNum) {
        Optional<Driver> driver = driverRepository.findByDriverNum(driverNum);
        if(driver.isPresent()){
            return driver.get();
        } else{
            throw new ResourceNotFoundException("Driver", "Driver Num", driverNum);
        }
    }

    @Override
    public Driver updateDriver(Driver driver, long id) {
        Driver existingDriver = driverRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Driver", "Id", id));

        existingDriver.setFirstname(driver.getFirstname());
        existingDriver.setLastname(driver.getLastname());
        existingDriver.setPassword(driver.getPassword());

        //save existing Driver to DB
        driverRepository.save(existingDriver);
        return existingDriver;
    }

    @Override
    public void deleteDriver(long id) {

        driverRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Driver", "Id", id));

        driverRepository.deleteById(id);
    }
}
