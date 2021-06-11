package com.ssen.springboottdd.service.impl;

import com.ssen.springboottdd.dto.CarRepository;
import com.ssen.springboottdd.exception.CarNotFoundException;
import com.ssen.springboottdd.model.Car;
import com.ssen.springboottdd.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository repository;

    @Autowired
    public CarServiceImpl(CarRepository repository){
        this.repository = repository;
    }

    @Override
    public Car getCarByName(String name) {
        Car byName = repository.findByName(name);
        if(byName == null){
            throw new CarNotFoundException();
        }
        return byName;
    }
}
