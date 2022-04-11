package com.example.week6.services;

import com.example.week6.components.Additional;
import com.example.week6.components.Availability;
import com.example.week6.components.Car;
import com.example.week6.components.DailyPrice;
import com.example.week6.repositories.AdditionalRepository;
import com.example.week6.repositories.AvailabelityRapository;
import com.example.week6.repositories.CarRepository;
import com.example.week6.repositories.DailyPriceRepository;
import org.springframework.stereotype.Service;

@Service
public class CarServices {

    CarRepository carRepository;
    DailyPriceRepository dailyPriceRepository;
    AvailabelityRapository availabelityRapository;
    AdditionalRepository additionalRepository;

    public CarServices(CarRepository carRepository, DailyPriceRepository dailyPriceRepository, AvailabelityRapository availabelityRapository, AdditionalRepository additionalRepository) {
        this.carRepository = carRepository;
        this.dailyPriceRepository = dailyPriceRepository;
        this.availabelityRapository = availabelityRapository;
        this.additionalRepository = additionalRepository;
    }

    public Long addCar(String type){
        Car car = new Car( type);
        carRepository.save(car);
        return  car.id();
    }

    public Car addDailyPrice(Long carId, DailyPrice dailyPrice){
        Car car = findCar(carId);

        car.dailyPrices().add(dailyPrice);

        dailyPriceRepository.save(dailyPrice);
        carRepository.save(car);

        return car;

    }

    public Car addAvailabelity(Long carId, Availability availability){
        Car car = findCar(carId);

        car.availabilities().add(availability);

        availabelityRapository.save(availability);
        carRepository.save(car);

        return car;
    }

    public Car addAdditionalService(Long carId, Additional additional){
        Car car = findCar(carId);

        car.additionalServices().add(additional);
        additionalRepository.save(additional);
        carRepository.save(car);
        return car;
    }

    public Car findCar(Long carId){
        Car car = carRepository.findById(carId).orElseThrow();
        return car;
    }
}
