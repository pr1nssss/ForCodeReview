package com.parkingapi.Parking.controllers;

import com.parkingapi.Parking.models.Car;
import com.parkingapi.Parking.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    // id = conduction sticker
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarInfo(@PathVariable Integer id) {
        return ResponseEntity.ok(carService.getCarInfoById(id));
    }

    // SLOTS : NULL
    @PostMapping("/{parkingId}/{slotId}")
    public ResponseEntity<Car> parkCar(@PathVariable Integer parkingId, @PathVariable Integer slotId, @RequestBody Car car) {
        return ResponseEntity.ok(carService.parkCar(parkingId, slotId, car));
    }


//    LAST PROBLEM
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Car>> unParkCar(@PathVariable Integer id) {
        carService.deleteCar(id);
        return ResponseEntity.ok(carService.getAllCars());
    }
}
