package com.tictactoe;

public class Board {

    private final char[][] board = new char[][]{
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public void printBoard() {
        for (char[] chars : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("|" + chars[j]);
            }
            System.out.println("|");
        }
    }

    public int getSize() {
        return 3;
    }

    public char getSign(int row, int col) {
        return board[row][col];
    }

    public void setSign(char sign, int row, int col) {
            board[row][col] = sign;
    }

    public boolean isFieldEmpty(int row, int col) {
        return board[row][col] == ' ';
    }
}
