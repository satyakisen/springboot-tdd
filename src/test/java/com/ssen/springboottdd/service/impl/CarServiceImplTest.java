package com.ssen.springboottdd.service.impl;

import com.ssen.springboottdd.dto.CarRepository;
import com.ssen.springboottdd.exception.CarNotFoundException;
import com.ssen.springboottdd.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CarServiceImplTest {

    @Mock
    CarRepository repository;

    private CarServiceImpl service;

    @BeforeEach
    public void setUp(){
        service = new CarServiceImpl(repository);
    }

    @Test
    public void testGetCarByName(){
        given(repository.findByName(anyString())).willReturn(new Car("prius", "hybrid"));
        Car carByName = service.getCarByName(anyString());
        assertNotNull(carByName);
        assertEquals("prius", carByName.getName());
        assertEquals("hybrid", carByName.getType());
    }

    @Test
    public void testGetCarByNameException(){
        Assertions.assertThrows(CarNotFoundException.class, () -> {
            given(repository.findByName(anyString())).willThrow(CarNotFoundException.class);
            Car carByName = service.getCarByName(anyString());
        });
    }
}