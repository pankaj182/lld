package org.neatcode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Player {
    private final Integer id;
    private final String name;
    private int wins;
    private int totalMatchesPlayed;
}
