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
        return board.length;
    }

    public char getSign(int row, int col) {
        return board[row][col];
    }

    public void setSign(char sign, int row, int col) {
            board[row][col] = sign;
    }

    public boolean isFieldEmpty(int row, int col) throws Exception {
        if (board[row][col] != ' ') {
            throw new Exception("The field is not empty! Try again.");
        }
        return true;
    }

    public int winCondition() {
        return 3;
    }
}
