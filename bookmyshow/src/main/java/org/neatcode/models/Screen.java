package org.neatcode.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Screen {
    @Setter(AccessLevel.NONE)
    private final Integer screenId;

    private List<Seat> seats;

    public Screen(Integer screenId) {
        this.screenId = screenId;
    }

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }

    public void addSeats(List<Seat> seats) {
        this.seats.addAll(seats);
    }
}
