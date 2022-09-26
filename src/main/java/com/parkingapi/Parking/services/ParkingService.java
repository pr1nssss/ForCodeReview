package com.parkingapi.Parking.services;

import com.parkingapi.Parking.Exceptions.ParkingNotFoundException;
import com.parkingapi.Parking.models.Parking;
import com.parkingapi.Parking.repositories.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingService {
    private final ParkingRepository parkingRepository;

    public Parking getParkingById(Integer id) {
        return parkingRepository
                .findById(id)
                .orElseThrow(() -> new ParkingNotFoundException("Parking not found!"));
    }

    public List<Parking> getAllParking() {
        return parkingRepository.findAll();
    }

    public Parking createParking(Parking parking) {
        return parkingRepository.save(parking);
    }

    public void deleteParking(Integer id) {
        parkingRepository.deleteById(id);
    }
}

