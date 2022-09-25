package com.parkingapi.Parking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Parking")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME", unique = true)
    private String name;

    @OneToMany(mappedBy = "parking")
    @JsonIgnoreProperties(value = {"parking"}, allowSetters = true)
    private List<Slot> slots;

    public void addSlot(Slot slot) {
        slots.add(slot);
    }
}
