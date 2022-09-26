package com.parkingapi.Parking.repositories;

import com.parkingapi.Parking.models.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Integer> {
    Optional<Slot> findByCarConductionNumber(Integer id);
}
