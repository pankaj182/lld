package org.neatcode.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class Show {
    @Setter(AccessLevel.NONE)
    private final int showId;

    private Movie movie;
    private Date startTime;
    private Screen screen;
    private Theatre theatre;
}
