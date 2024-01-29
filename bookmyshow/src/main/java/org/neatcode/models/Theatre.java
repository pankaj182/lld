package org.neatcode.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class Theatre {
    @Setter(AccessLevel.NONE)
    private final Integer theatreId;

    private final String name;

    private List<Screen> screens;

    public Theatre(Integer theatreId, String name) {
        this.theatreId = theatreId;
        this.name = name;
        this.screens = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        this.screens.add(screen);
    }

    public void removeScreen(Screen screen) {
        this.screens.removeIf(s -> s.getScreenId() == screen.getScreenId());
    }
}
