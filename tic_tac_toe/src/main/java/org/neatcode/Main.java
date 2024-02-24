package org.neatcode;

public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        int res = ticTacToe.move(0,0, 1);
        ticTacToe.printBoard();
        print(res);

        res = ticTacToe.move(0,2, 2);
        ticTacToe.printBoard();
        print(res);

        res = ticTacToe.move(1,1, 1);
        ticTacToe.printBoard();
        print(res);

        res = ticTacToe.move(1,2, 2);
        ticTacToe.printBoard();
        print(res);

        res = ticTacToe.move(2,2, 1);
        ticTacToe.printBoard();
        print(res);
    }

    static void print(int x) {
        System.out.println("Winner is " + (Boolean.valueOf(x == 0)? "not decided yet" : x));
    }
}