package com.tictactoe;

public class Board10 extends Board {

    private final char[][] board = new char[][]{
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
    };

    @Override
    public void printBoard() {
        for (char[] chars : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("|" + chars[j]);
            }
            System.out.println("|");
        }
    }

    @Override
    public int getSize() {
        return board.length;
    }

    @Override
    public char getSign(int row, int col) {
        return board[row][col];
    }

    @Override
    public void setSign(char sign, int row, int col) {
        board[row][col] = sign;
    }

    @Override
    public boolean isFieldEmpty(int row, int col) throws Exception {
        if (board[row][col] != ' ') {
            throw new Exception("The field is not empty! Try again.");
        }
        return true;
    }

    @Override
    public int winCondition() {
        return 5;
    }
}
