package com.ssen.springboottdd.controller;

import com.ssen.springboottdd.exception.CarNotFoundException;
import com.ssen.springboottdd.model.Car;
import com.ssen.springboottdd.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService service;


    @Test
    public void testGetCar() throws Exception {
        given(service.getCarByName(anyString())).willReturn(new Car("prius", "hybrid"));

        mockMvc.perform(get("/car/prius").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath(".name").value("prius"))
                .andExpect(jsonPath(".type").value("hybrid"));
    }

    @Test
    public void testGetCarException() throws Exception {
        given(service.getCarByName(anyString())).willThrow(CarNotFoundException.class);

        mockMvc.perform(get("/car/prius").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}