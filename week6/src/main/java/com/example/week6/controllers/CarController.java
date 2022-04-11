package com.example.week6.controllers;

import com.example.week6.components.Additional;
import com.example.week6.components.Availability;
import com.example.week6.components.Car;
import com.example.week6.components.DailyPrice;
import com.example.week6.services.CarServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("/car")
public class CarController {

    private CarServices carServices;

    public CarController(CarServices carServices) {
        this.carServices = carServices;
    }

    @PutMapping("/add")
    public Long addCar(String type){
        return carServices.addCar(type);
    }

    @PostMapping("/{id}/add-daily-price")
    public Car addDailyPrice(@PathVariable Long id, @RequestBody DailyPrice dailyPrice){
        return carServices.addDailyPrice(id,dailyPrice);
    }

    @PostMapping("/{id}/add-availabelity")
    public Car addAvalebelity(@PathVariable Long id, @RequestBody Availability availability){
        return carServices.addAvailabelity(id,availability);
    }

    @PostMapping("/{id}/add-additional")
    public Car addAdditonalService(@PathVariable Long id, @RequestBody Additional additional){
        return carServices.addAdditionalService(id,additional);
    }
}
