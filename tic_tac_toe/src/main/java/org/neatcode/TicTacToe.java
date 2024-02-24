package org.neatcode;

public class TicTacToe {
    private int boardSize;
    private int[][] board;
    private int moveCount;
    public TicTacToe(int n) {
        this.boardSize = n;
        this.board = new int[n][n];
        this.moveCount = 0;
    }

    public int move(int row, int col, int player) {
        moveCount++;
        board[row][col] = player;
        if(isWinner(row, col, player)) {
            return player;
        }
        return 0;
    }

    private boolean isWinner(int i, int j, int player) {
        if(moveCount < 2*boardSize-1) {
            return false;
        }
        int x,y;
        // row
        for(x = 0; x<boardSize; x++) {
            if(board[i][x] != player) {
                break;
            }
        }
        if(x == boardSize) return true;
        // col
        for(x = 0; x<boardSize;x++) {
            if(board[x][j] != player) {
                break;
            }
        }
        if(x == boardSize) return true;
        // pricipal diagnol
        if(i == j) {

            for(x = 0; x < boardSize; x++) {
                if(board[x][x] != player) {
                    break;
                }
            }
            if(x == boardSize) return true;
        }
        // other diagonal
        if(i+j == boardSize-1) {
            for(x = 0,y=boardSize-1; x<boardSize;x++,y--) {
                if(board[x][y] != player) {
                    break;
                }
            }
            if(x == boardSize) return true;
        }
        return false;
    }

    public void printBoard() {
        for(int i = 0; i< boardSize; i++) {
            for(int j = 0; j<boardSize; j++) {
                System.out.print(board[i][j] +"  ");
            }
            System.out.println();
        }
    }
}
