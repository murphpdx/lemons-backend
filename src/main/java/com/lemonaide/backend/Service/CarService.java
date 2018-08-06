package com.lemonaide.backend.Service;

import com.lemonaide.backend.SpringRepository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lemonaide.backend.RedisRepository.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public void populateCarInfo() {
        List<Car> list = new ArrayList<>();


        list.add(new Car(UUID.randomUUID().toString(),"Toyota", "Camry", "2018", "Black"));
        list.add(new Car(UUID.randomUUID().toString(),"Honda", "Accord", "2018", "Red"));

        carRepository.saveAll(list);
    }

    public Iterable<Car> getAllCarInfo() {
        return carRepository.findAll();
    }
}
