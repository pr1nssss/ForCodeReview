package com.parkingapi.Parking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "Slot")
@Entity
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "SLOT_ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "CAR_CONDUCTION_NUMBER", referencedColumnName = "CONDUCTION_NUMBER")
    @JsonIgnoreProperties(value = {"slot"})
    private Car car;

    @ManyToOne
    @JoinColumn(name = "PARKING_ID", referencedColumnName = "ID")
    @JsonIgnoreProperties(value= {"slots"})
    private Parking parking;

    public void addCar(Car car) {
        this.car = car;
    }

    public void addParking(Parking parking) {
        this.parking = parking;
    }
}
