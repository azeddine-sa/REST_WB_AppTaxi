package be.azsa.apptaxi.service.impl;

import be.azsa.apptaxi.repository.CarRepository;
import be.azsa.apptaxi.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    //Constructor
    public CarServiceImpl(CarRepository carRepository) { this.carRepository = carRepository; }

}
