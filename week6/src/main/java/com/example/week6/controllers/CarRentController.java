package com.example.week6.controllers;

import com.example.week6.services.CarRentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;

@Controller("/car-rent")
public class CarRentController {

    CarRentService carRentService;

    public CarRentController(CarRentService carRentService) {
        this.carRentService = carRentService;
    }

    @PutMapping("/add")
    public Long addCarRent(String name, String city){
        return  carRentService.addCarRent(name,city);
    }
}
