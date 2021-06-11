package com.ssen.springboottdd.dto;

import com.ssen.springboottdd.model.Car;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRepository extends CassandraRepository<Car, UUID> {
    Car findByName(String name);
}
