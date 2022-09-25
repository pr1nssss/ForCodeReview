package com.parkingapi.Parking.services;

import com.parkingapi.Parking.models.Slot;
import com.parkingapi.Parking.repositories.SlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SlotService {
    private final ParkingService parkingService;
    private final SlotRepository slotRepository;

    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    public Boolean isAvailable(Integer id) {
        return (slotRepository.findById(id).get().getCar() == null);
    }

    public Slot createSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    public List<Slot> bulkCreateSlots(Integer parkingId, List<Slot> slots) {
        slots.forEach(slot -> slot.setParking(parkingService.getParkingById(parkingId)));
        return slotRepository.saveAll(slots);
    }

    public void deleteSlot(Integer id) {
            slotRepository.deleteById(id);
    }
}
