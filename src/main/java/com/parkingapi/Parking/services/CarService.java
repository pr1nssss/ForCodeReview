package com.parkingapi.Parking.services;

import com.parkingapi.Parking.Exceptions.CarNotFoundException;
import com.parkingapi.Parking.Exceptions.ParkingNotFoundException;
import com.parkingapi.Parking.Exceptions.SlotNotFoundException;
import com.parkingapi.Parking.models.Car;
import com.parkingapi.Parking.repositories.CarRepository;
import com.parkingapi.Parking.repositories.ParkingRepository;
import com.parkingapi.Parking.repositories.SlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final SlotService slotService;
    private final SlotRepository slotRepository;
    private final ParkingRepository parkingRepository;

    public Car getCarInfoById(Integer id){
        return carRepository
                .findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found!"));
    }

    public Car parkCar(Integer parkingId, Integer slotId, Car car) {

        var parking = parkingRepository
                .findById(parkingId)
                .orElseThrow(() -> new ParkingNotFoundException("Parking not found!"));

        var slot = slotRepository
                .findById(slotId)
                .orElseThrow(()-> new SlotNotFoundException("Slot not found!"));
        if (slotService.isAvailable(slotId)) {
            parking.addSlot(slot);
            slot.addParking(parking);
            slot.addCar(car);
        } else {
            System.out.println("Slot is not available.");
        }

        return carRepository.save(car);
    }

    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
