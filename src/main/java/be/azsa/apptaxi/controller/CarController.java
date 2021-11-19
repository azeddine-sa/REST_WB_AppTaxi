package be.azsa.apptaxi.controller;

import be.azsa.apptaxi.service.CarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) { this.carService = carService; }
}
