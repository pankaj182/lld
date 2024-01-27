package org.neatcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GameService {

    private Queue<Player> players;
    private Queue<Player> leaderBoard;
    private Map<Integer, Integer> currentPos;
    private Board board;
    private Dice dice;

    private final int START_POS = 0;
    private final int WINNING_POS;

    public GameService(Queue<Player> players, Board board) {
        this.WINNING_POS = board.getBoardSize() * board.getBoardSize();
        this.currentPos = new HashMap<>();
        this.players = new ConcurrentLinkedQueue<>();
        for(Player player: players) {
            currentPos.put(player.getId(), START_POS);
            this.players.add(player);
        }
        dice = new Dice();
        this.board = board;
        leaderBoard = new LinkedList<>();
    }

    public void startGame() {
        for(Player player: players) {
            player.setTotalMatchesPlayed(player.getTotalMatchesPlayed()+1);
        }
        StringBuilder message = new StringBuilder();
        while (players.size() >= 2) {
            for(Player player: players) {
                message.append("\n").append(player.getName()).append("'s turn.");
                int diceNumber = dice.getRandomNumber();
                message.append(" Dice Rolled At: ").append(diceNumber);
                int currPos = currentPos.get(player.getId());
                int newPos = currPos + diceNumber;
                message.append(". Moving From ").append(currPos).append(" to ").append(newPos);
                if(board.getLadderFootAndHeadPosition().containsKey(newPos)) {
                    message.append("\nShoot! Encountered Ladder. ").append("moved from ").append(newPos).append(" to ");
                    newPos = board.getLadderFootAndHeadPosition().get(newPos);
                    message.append(newPos);
                }
                if(board.getSnakesHeadAndTailPosition().containsKey(newPos)) {
                    message.append("\nNoice! Encountered a Snake. ").append("moved from ").append(newPos).append(" to ");
                    newPos = board.getSnakesHeadAndTailPosition().get(newPos);
                    message.append(newPos);
                }
                if(newPos > WINNING_POS) {
                    message.append("\nNew Position Exceeds Winning Position of ").append(WINNING_POS);
                }
                else if(newPos == WINNING_POS) {
                    leaderBoard.add(player);
                    player.setWins(player.getWins()+1);
                    players.remove(player);
                    message.append("\nHurray!!! ").append(player.getName()).append(" Wins finishing with Rank ").append(leaderBoard.size());
                    currentPos.remove(player.getId());
                } else {
                    currentPos.put(player.getId(), newPos);
                }
                System.out.println(message);
                message.delete(0, message.length());
            }
        }
        System.out.println("\n\nWell Played.\n\n");
        leaderBoard.add(players.peek());
        printLeaderBoard();
    }

    private void printLeaderBoard() {
        System.out.println("LeaderBoard");
        int rank = 1;
        for(Player player: leaderBoard) {
            System.out.println(rank + " : " + player.getName());
            rank++;
        }
    }
}
