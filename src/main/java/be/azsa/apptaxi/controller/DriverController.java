package be.azsa.apptaxi.controller;

import be.azsa.apptaxi.model.Driver;
import be.azsa.apptaxi.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) { this.driverService = driverService; }

    //POST
    // build create employee REST API
    @PostMapping("driver/add")
    public ResponseEntity<Driver> saveDriver(@RequestBody Driver driver){
        return new ResponseEntity<>(driverService.saveDriver(driver), HttpStatus.CREATED);
    }

    //GET
    //build get all users REST API
    @GetMapping("drivers")
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    //build get user by id REST API
    //localhost:8080/api/drivers/1
    @GetMapping("driver/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable("id") long idDriver){
        return new ResponseEntity<>(driverService.getDriverById(idDriver), HttpStatus.OK);
    }

    //PUT
    //build update user REST API
    //localhost:8080/api/users/1
    @PutMapping("/driver/{id}/edit")
    public ResponseEntity<Driver> updateDriver(@PathVariable("id") long id, @RequestBody Driver driver){
        return new ResponseEntity<>(driverService.updateDriver(driver, id), HttpStatus.OK);
    }

    //DELETE
    //build deleter user REST API
    @DeleteMapping("driver/{id}/delete")
    public ResponseEntity<String> deleteDriver(@PathVariable("id") long id){
        driverService.deleteDriver(id);

        return new ResponseEntity<String>("Driver deleted successfully!", HttpStatus.OK);
    }

}
