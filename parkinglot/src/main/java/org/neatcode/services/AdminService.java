package org.neatcode.services;

import org.neatcode.enums.SlotType;
import org.neatcode.models.ParkingFloor;
import org.neatcode.models.ParkingSlot;

public interface AdminService {
    ParkingFloor createFloor(int id);

    ParkingSlot createSlot(int slotId, SlotType slotType);

    void addSlot(int floorId, ParkingSlot parkingSlot);
}
