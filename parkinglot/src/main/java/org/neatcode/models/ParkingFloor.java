package org.neatcode.models;

import org.neatcode.enums.SlotType;

import java.util.*;

public class ParkingFloor {
    private int floorId;
    private Map<SlotType, List<ParkingSlot>> slots;

    public ParkingFloor(int floorId) {
        this.floorId = floorId;
        this.slots = new HashMap<>();
        for(SlotType type: EnumSet.allOf(SlotType.class)) {
            slots.put(type, new ArrayList<>());
        }
    }

    public void addParkingSlot(ParkingSlot parkingSlot) {
        this.slots.get(parkingSlot);
    }

    public int getFloorId() {
        return floorId;
    }
}
