package org.neatcode;

import lombok.Getter;
import lombok.Setter;
import org.neatcode.exceptions.InvalidBoardException;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class Board {
    private final int boardSize;
    private final int snakesCount;
    private final int ladderCount;
    private final Map<Integer, Integer> snakesHeadAndTailPosition;
    private final Map<Integer, Integer> ladderFootAndHeadPosition;

    private Board(BoardBuilder builder) {
        this.boardSize = builder.boardSize;
        this.snakesCount = builder.snakesCount;
        this.ladderCount = builder.ladderCount;
        this.snakesHeadAndTailPosition = new TreeMap<>();
        this.ladderFootAndHeadPosition = new TreeMap<>();
        for(int i = 0; i< snakesCount; i++) {
            this.snakesHeadAndTailPosition.put(builder.snakesPos[2*i], builder.snakesPos[2*i+1]);
        }
        for(int i = 0; i< ladderCount; i++) {
            this.ladderFootAndHeadPosition.put(builder.ladderPos[2*i], builder.ladderPos[2*i+1]);
        }
    }

    public static class BoardBuilder {
        public static final int DEFAULT_BOARD_SIZE = 10;
        public static final int DEFAULT_LADDER_COUNT = 10;
        public static final int DEFAULT_SNAKES_COUNT = 10;

        private int boardSize;
        private int snakesCount;
        private int ladderCount;
        private int[] snakesPos;
        private int[] ladderPos;

        private boolean optDefault = false;

        public BoardBuilder() {
            this.boardSize = DEFAULT_BOARD_SIZE;
            this.snakesCount = DEFAULT_SNAKES_COUNT;
            this.ladderCount = DEFAULT_LADDER_COUNT;
        }

        public BoardBuilder withSize(int n) {
            this.boardSize = n;
            return this;
        }

        public BoardBuilder withSnakesCount(int snakesCount) {
            this.snakesCount = snakesCount;
            return this;
        }

        public BoardBuilder withLadderCount(int ladderCount) {
            this.ladderCount = ladderCount;
            return this;
        }

        public BoardBuilder withSnakesAt(int[] snakesPosition) throws InvalidBoardException {
            if(snakesPosition == null || snakesPosition.length == 0 || snakesPosition.length % 2 == 1) {
                throw new InvalidBoardException("Invalid Snakes Configuration");
            }
            this.snakesPos = snakesPosition;
            this.snakesCount = snakesPos.length/2;
            return this;
        }

        public BoardBuilder withLaddersAt(int[] laddersPosition) throws InvalidBoardException {
            if(laddersPosition == null || laddersPosition.length == 0 || laddersPosition.length % 2 == 1) {
                throw new InvalidBoardException("Invalid Ladder Configuration");
            }
            this.ladderPos = laddersPosition;
            this.ladderCount = ladderPos.length/2;
            return this;
        }

        public BoardBuilder optDefaults() {
            this.optDefault = true;
            return this;
        }

        public Board build() throws InvalidBoardException {
            if(optDefault) {
                if(snakesPos == null || snakesPos.length == 0) {
                    this.configureDefaultSnakes(this.snakesCount);
                }
                if(ladderPos == null || ladderPos.length == 0) {
                    this.configureDefaultLadders(this.ladderCount);
                }
            }
            validateBoard();
            return new Board(this);
        }

        private void configureDefaultSnakes(int snakesCount) {
            this.snakesPos = new int[snakesCount*2];
            int a, b, max, min;
            for(int i = 0; i<snakesCount;) {
                a = (int) ((Math.random() * (this.boardSize * this.boardSize) - 3) + 2); // for 10*10 -> (2, 99)
                b = (int) ((Math.random() * (this.boardSize * this.boardSize) - 3) + 2); // for 10*10 -> (2, 99)
                min = Math.min(a, b);
                max = Math.max(a, b);
                if(min != max) {
                    snakesPos[2*i] = max;
                    snakesPos[2*i+1] = min;
                    i++;
                }
            }
        }

        private void configureDefaultLadders(int ladderCount) {
            this.ladderPos = new int[ladderCount*2];
            int a, b, max, min;
            for(int i = 0; i<ladderCount;) {
                a = (int) ((Math.random() * (this.boardSize * this.boardSize) - 3) + 2); // for 10*10 -> (2, 99)
                b = (int) ((Math.random() * (this.boardSize * this.boardSize) - 3) + 2); // for 10*10 -> (2, 99)
                min = Math.min(a, b);
                max = Math.max(a, b);
                if(min != max) {
                    ladderPos[2*i] = min;
                    ladderPos[2*i+1] = max;
                    i++;
                }
            }
        }

        private void validateBoard() throws InvalidBoardException {
            if(boardSize <= 0) {
                throw new InvalidBoardException("Board size cannot be negative");
            }

            if(snakesCount <= 0 || snakesPos == null || snakesPos.length == 0 || 2*snakesCount != snakesPos.length) {
                throw new InvalidBoardException("Invalid Snakes Configuration");
            }

            if(ladderCount <= 0 || ladderPos == null || ladderPos.length == 0 || 2*ladderCount != ladderPos.length) {
                throw new InvalidBoardException("Invalid Ladders Configuration");
            }

            if(boardSize*boardSize <= snakesCount*2) {
                throw new InvalidBoardException("Snakes cannot be accommodated in the board");
            }

            if(boardSize*boardSize <= ladderCount*2) {
                throw new InvalidBoardException("Ladders cannot be accommodated in the board");
            }


        }

        private boolean isValidSnakesPos() throws InvalidBoardException {
            for(int i = 0; i < snakesCount; i++) {
                if(snakesPos[2*i] == boardSize*boardSize) {
                    throw new InvalidBoardException("Snakes Head cannot be at winning mark");
                }
            }
            return true;
        }
    }

}
