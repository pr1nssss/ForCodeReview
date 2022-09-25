package com.parkingapi.Parking.controllers;

import com.parkingapi.Parking.models.Slot;
import com.parkingapi.Parking.services.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slots")
@RequiredArgsConstructor
public class SlotController {

    private final SlotService slotService;

    //    NOT WORKING PROPERLY. BECAUSE OF IS PRESENT INSTEAD OF IS EMPTY
    @GetMapping("/{id}")
    public ResponseEntity<Boolean> checkSlotAvailability(@PathVariable Integer id) {
        return ResponseEntity.ok(slotService.isAvailable(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<List<Slot>> createSlots(@PathVariable Integer id, @RequestBody List<Slot> slots) {
        return ResponseEntity.ok(slotService.bulkCreateSlots(id, slots));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Slot>> deleteSlot(@PathVariable Integer id) {
        if (slotService.isAvailable(id))
            slotService.deleteSlot(id);
        else {
            System.out.println("Slot is occupied!");
        }
        return ResponseEntity.ok(slotService.getAllSlots());
    }
}
