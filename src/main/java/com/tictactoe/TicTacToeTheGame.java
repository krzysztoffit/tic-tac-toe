package com.tictactoe;

import java.util.Scanner;

public class TicTacToeTheGame {

    private static final Scanner scanner = new Scanner(System.in);
    private final Board board = new Board();
    private final Player xPlayer = new Player('X');
    private final Player oPlayer = new Player('O');

    public void playTheGame() {
        Player activePlayer = xPlayer;
        boolean gameOver = false;
        int counter = 0;
        int col;
        int row;

        while (!gameOver) {
            board.boardDraw();
            System.out.print("Choose row: ");
            row = scanner.nextInt() - 1;
            System.out.print("Choose column: ");
            col = scanner.nextInt() - 1;
            if (checkFieldIsEmpty(row, col, board)) {
                placeTheSign(activePlayer, row, col, board);
                gameOver = checkTheWin(activePlayer, row, col, board);
                counter++;
                if (counter == 9 && !gameOver) {
                    System.out.println("There is a draw!");
                    board.boardDraw();
                    gameOver = true;
                }
                if (xPlayer.equals(activePlayer)) {
                    activePlayer = oPlayer;
                } else if (oPlayer.equals(activePlayer)) {
                    activePlayer = xPlayer;
                }
            } else {
                System.out.println("This field is not empty! Try again.");
            }
        }
    }

    public boolean checkTheWin(Player activePlayer, int row, int col, Board board) {
        char sign = activePlayer.getSign();
        int signCounter;

        signCounter = 0;
        for (int i = 0; i < board.board.length; i++) {
            if (board.board[row][i] == sign) {
                signCounter++;
            }
            if (signCounter == 3) {
                System.out.println("Player " + sign + " wins!");
                board.boardDraw();
                return true;
            }
        }

        signCounter = 0;
        for (int i = 0; i < board.board.length; i++) {
            if (board.board[i][col] == sign) {
                signCounter++;
            }
            if (signCounter == 3) {
                System.out.println("Player " + sign + " wins!");
                board.boardDraw();
                return true;
            }
        }

        signCounter = 0;
        for (int i = 0; i < board.board.length; i++) {
            if (board.board[i][i] == sign) {
                signCounter++;
            }
            if (signCounter == 3) {
                System.out.println("Player " + sign + " wins!");
                board.boardDraw();
                return true;
            }
        }

        signCounter = 0;
        int colMax = 2;
        for (int i = 0; i < board.board.length; i++) {
            if (board.board[i][colMax] == sign) {
                signCounter++;
            }
            if (signCounter == 3) {
                System.out.println("Player " + sign + " wins!");
                board.boardDraw();
                return true;
            }
            colMax--;
        }

        return false;
    }

    private boolean checkFieldIsEmpty(int row, int col, Board board) {
        return board.board[row][col] == ' ';
    }

    public void placeTheSign(Player activePlayer, int row, int col, Board board) {
        char sign = ' ';
        if (xPlayer.equals(activePlayer)) {
            sign = xPlayer.getSign();
        } else if (oPlayer.equals(activePlayer)) {
            sign = oPlayer.getSign();
        }
        board.board[row][col] = sign;
    }
}
