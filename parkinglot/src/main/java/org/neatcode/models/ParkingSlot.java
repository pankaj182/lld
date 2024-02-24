package org.neatcode.models;

import org.neatcode.enums.SlotStatus;
import org.neatcode.enums.SlotType;

public class ParkingSlot {
    private int slotId;
    private SlotType slotType;
    private SlotStatus slotStatus;

    ParkingSlot(int slotId, SlotType slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.slotStatus = SlotStatus.AVAILABLE;
    }

    public static ParkingSlot with(int slotId, SlotType type) {
        return new ParkingSlot(slotId, type);
    }
}
