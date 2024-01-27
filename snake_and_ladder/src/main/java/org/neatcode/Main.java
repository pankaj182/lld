package org.neatcode;

import org.neatcode.exceptions.InvalidBoardException;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws InvalidBoardException {
        Player pankaj = new Player(1, "Pankaj");
        Player prakashniya = new Player(2, "Prakashniya");
        Player abhishek = new Player(3, "Abhishek");
        Player prashant = new Player(4, "Prashant");
        Player rumita = new Player(5, "Rumita");
        Player andril = new Player(6, "Andril");

        Queue<Player> players = new LinkedList<>();
        players.add(pankaj);
        players.add(prakashniya);
        players.add(abhishek);
        players.add(prashant);
        players.add(rumita);
        players.add(andril);

        Board board = new Board.BoardBuilder().optDefaults().build();

        GameService gameService = new GameService(players, board);
        gameService.startGame();
    }
}
