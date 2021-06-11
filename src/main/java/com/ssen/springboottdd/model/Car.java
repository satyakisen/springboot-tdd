package com.ssen.springboottdd.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("CAR")
public class Car {

    @Column("type")
    private String type;

    @PrimaryKey
    @Column("name")
    private String name;

    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
