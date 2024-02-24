package org.neatcode.services;

import org.neatcode.enums.VehicleType;
import org.neatcode.models.ParkingTicket;

public interface ParkingService {

    ParkingTicket parkVehicle();

    int unParkVehicle();

    /**
     * checks if there is a slot availability for a given type of vehicle
     * @param type {@link VehicleType}
     * @return true if a slot is available
     */
    boolean isSlotAvailable(VehicleType type);

    /**
     * @return Number of vehicles parked
     */
    int countOfParkedVehicles();

    /**
     * May be for maintenance, or some construction nearby or water leaks there
     */
    void makeSlotUnavailable();

    /**
     * make the slot available after maintenance
     */
    void makeSlotAvailable();
}
