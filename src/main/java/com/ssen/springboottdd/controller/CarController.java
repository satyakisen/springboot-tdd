package com.ssen.springboottdd.controller;

import com.ssen.springboottdd.model.Car;
import com.ssen.springboottdd.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/car/{name}")
    public ResponseEntity<Car> getCarByName(@PathVariable String name){
        return new ResponseEntity<>(carService.getCarByName(name), HttpStatus.OK);
    }
}
