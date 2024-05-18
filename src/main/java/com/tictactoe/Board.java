package com.tictactoe;

public class Board {

    protected char[][] board = new char[][]{
            {'|', ' ', '|', ' ', '|', ' ', '|'},
            {'|', ' ', '|', ' ', '|', ' ', '|'},
            {'|', ' ', '|', ' ', '|', ' ', '|'}
    };

    public void boardDraw() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 6; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
