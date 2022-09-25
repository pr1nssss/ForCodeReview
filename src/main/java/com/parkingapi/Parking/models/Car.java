package com.parkingapi.Parking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "Car")
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONDUCTION_NUMBER")
    private Integer conductionNumber;
    @Column(name = "BRAND")
    private String brand;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "TYPE")
    private String type;

    @OneToOne(mappedBy = "car")
    @JsonIgnoreProperties(value = "car")
    private Slot slot;

    public void addSlot(Slot slot) {
        this.slot = slot;
    }
}
