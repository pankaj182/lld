package org.neatcode.adapters;

import org.neatcode.enums.SlotType;
import org.neatcode.models.ParkingFloor;
import org.neatcode.models.ParkingSlot;
import org.neatcode.services.AdminService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdminAdapter implements AdminService {
    private List<ParkingFloor> floors;
    private AdminAdapter() {
        this.floors = new ArrayList<>();
    }
    @Override
    public ParkingFloor createFloor(int id) {
        ParkingFloor floor = new ParkingFloor(id);
        floors.add(floor);
        return floor;
    }

    @Override
    public ParkingSlot createSlot(int slotId, SlotType slotType) {
        return ParkingSlot.with(slotId, slotType);
    }

    @Override
    public void addSlot(int floorId, ParkingSlot parkingSlot) {
        Optional<ParkingFloor> optionalFloor = floors.stream().filter(f -> f.getFloorId() == floorId).findFirst();
        ParkingFloor floor = optionalFloor.orElseThrow();
        floor.addParkingSlot(parkingSlot);
    }
}
