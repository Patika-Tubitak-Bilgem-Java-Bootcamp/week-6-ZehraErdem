package com.example.week6.services;

import com.example.week6.components.CarRent;
import com.example.week6.repositories.CarRentRepository;
import org.springframework.stereotype.Service;

@Service
public class CarRentService {

    private CarRentRepository carRentRepository;

    public CarRentService(CarRentRepository carRentRepository) {
        this.carRentRepository = carRentRepository;
    }

    public Long addCarRent(String name, String city){
        CarRent carRent = new CarRent(name, city);
        carRentRepository.save(carRent);
        return carRent.id();
    }
}
