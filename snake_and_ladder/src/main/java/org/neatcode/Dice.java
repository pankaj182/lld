package org.neatcode;

public class Dice {

    private static final int DEFAULT_DICE_COUNT = 1;
    private static final int MAX_DICE_NUMBER = 6;

    private final int diceCount;

    public Dice() {
        this(DEFAULT_DICE_COUNT);
    }

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int getRandomNumber() {
        return (int)(Math.random() * (diceCount * MAX_DICE_NUMBER - 1) + 1);
    }
}
