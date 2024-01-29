package org.neatcode.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Booking {
    @Setter(AccessLevel.NONE)
    private final int bookingId;

    private Show show;
    private List<Seat> bookedSeats;
    private BookingStatus bookingStatus;
    private User user;
}
