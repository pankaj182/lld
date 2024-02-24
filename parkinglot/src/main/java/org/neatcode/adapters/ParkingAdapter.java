package org.neatcode.adapters;

import org.neatcode.enums.VehicleType;
import org.neatcode.models.ParkingTicket;
import org.neatcode.services.ParkingService;

public class ParkingAdapter implements ParkingService {
    @Override
    public ParkingTicket parkVehicle() {
        return null;
    }

    @Override
    public int unParkVehicle() {
        return 0;
    }

    @Override
    public boolean isSlotAvailable(VehicleType type) {
        return false;
    }

    @Override
    public int countOfParkedVehicles() {
        return 0;
    }

    @Override
    public void makeSlotUnavailable() {

    }

    @Override
    public void makeSlotAvailable() {

    }
}
