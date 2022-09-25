package com.parkingapi.Parking.services;

import com.parkingapi.Parking.Exceptions.ParkingNotFoundException;
import com.parkingapi.Parking.models.Parking;
import com.parkingapi.Parking.repositories.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParkingService {
    private final ParkingRepository parkingRepository;

    public Parking getParkingById(Integer id) {
        Optional<Parking> optional = parkingRepository.findById(id);
        if (optional.isEmpty())
            throw new ParkingNotFoundException("Parking 404!");
        return optional.get();
    }

    public List<Parking> getAllParking(){
        return parkingRepository.findAll();
    }

    public boolean hasAvailableSlot(){
        return parkingRepository.findAll().contains(null);
    }

    public Parking createParking(Parking parking) {
        return parkingRepository.save(parking);
    }

    public void deleteParking(Integer id) {
            parkingRepository.deleteById(id);
    }

}

