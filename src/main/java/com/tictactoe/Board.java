package com.tictactoe;

public class Board {

    protected char[][] board = new char[][]{
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public void boardDraw() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
    }
}
