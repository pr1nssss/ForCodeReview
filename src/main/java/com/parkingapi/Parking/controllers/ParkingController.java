package com.parkingapi.Parking.controllers;

import com.parkingapi.Parking.models.Parking;
import com.parkingapi.Parking.services.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkings")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;

    @GetMapping("/{id}")
    public ResponseEntity<Parking> getParkingById(@PathVariable Integer id) {
        return ResponseEntity.ok(parkingService.getParkingById(id));
    }

    @GetMapping
    public ResponseEntity<List<Parking>> getAllParking(){
        return ResponseEntity.ok(parkingService.getAllParking());
    }

    @PostMapping
    public ResponseEntity<Parking> createParking(@RequestBody Parking parking) {
        return ResponseEntity.ok(parkingService.createParking(parking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Parking>> deleteParking(@PathVariable Integer id) {
        parkingService.deleteParking(id);
        return ResponseEntity.ok(parkingService.getAllParking());
    }
}

