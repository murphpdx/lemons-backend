package com.lemonaide.backend.Controller;


import com.lemonaide.backend.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecallController {

    @Autowired
    CarService carService;

    @GetMapping("/all")
    public String getAll() {
        return carService.getAllCarInfo().toString();
    }

    @GetMapping("/populate")
    public void populateCars() {
        carService.populateCarInfo();
    }
}
