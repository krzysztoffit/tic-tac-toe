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
        int field;

        while (!gameOver) {
            board.boardDraw();
            System.out.print("Choose field (1-9): ");
            field = scanner.nextInt();
            if (checkFieldIsEmpty(field, board)) {
                placeTheSign(activePlayer, field, board);
                gameOver = checkTheWin(activePlayer, board);
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

    public boolean checkTheWin(Player activePlayer, Board board) {
        char sign = activePlayer.getSign();

        if (board.board[0][1] == sign && board.board[0][3] == sign && board.board[0][5] == sign) {
            System.out.println("Player " + activePlayer.getSign() + " win!");
            board.boardDraw();
            return true;
        }
        if (board.board[1][1] == sign && board.board[1][3] == sign && board.board[1][5] == sign) {
            System.out.println("Player " + activePlayer.getSign() + " win!");
            board.boardDraw();
            return true;
        }
        if (board.board[2][1] == sign && board.board[2][3] == sign && board.board[2][5] == sign) {
            System.out.println("Player " + activePlayer.getSign() + " win!");
            board.boardDraw();
            return true;
        }
        if (board.board[0][1] == sign && board.board[1][1] == sign && board.board[2][1] == sign) {
            System.out.println("Player " + activePlayer.getSign() + " win!");
            board.boardDraw();
            return true;
        }
        if (board.board[0][3] == sign && board.board[1][3] == sign && board.board[2][3] == sign) {
            System.out.println("Player " + activePlayer.getSign() + " win!");
            board.boardDraw();
            return true;
        }
        if (board.board[0][5] == sign && board.board[1][5] == sign && board.board[2][5] == sign) {
            System.out.println("Player " + activePlayer.getSign() + " win!");
            board.boardDraw();
            return true;
        }
        if (board.board[0][1] == sign && board.board[1][3] == sign && board.board[2][5] == sign) {
            System.out.println("Player " + activePlayer.getSign() + " win!");
            board.boardDraw();
            return true;
        }
        if (board.board[0][5] == sign && board.board[1][3] == sign && board.board[2][1] == sign) {
            System.out.println("Player " + activePlayer.getSign() + " win!");
            board.boardDraw();
            return true;
        }
        return false;
    }

    private boolean checkFieldIsEmpty(int field, Board board) {
        return switch (field) {
            case 1 -> board.board[0][1] == ' ';
            case 2 -> board.board[0][3] == ' ';
            case 3 -> board.board[0][5] == ' ';
            case 4 -> board.board[1][1] == ' ';
            case 5 -> board.board[1][3] == ' ';
            case 6 -> board.board[1][5] == ' ';
            case 7 -> board.board[2][1] == ' ';
            case 8 -> board.board[2][3] == ' ';
            case 9 -> board.board[2][5] == ' ';
            default -> false;
        };
    }

    public void placeTheSign(Player activePlayer, int field, Board board) {

        char sign = ' ';
        if (xPlayer.equals(activePlayer)) {
            sign = xPlayer.getSign();
        } else if (oPlayer.equals(activePlayer)) {
            sign = oPlayer.getSign();
        }

        switch (field) {
            case 1:
                board.board[0][1] = sign;
                break;
            case 2:
                board.board[0][3] = sign;
                break;
            case 3:
                board.board[0][5] = sign;
                break;
            case 4:
                board.board[1][1] = sign;
                break;
            case 5:
                board.board[1][3] = sign;
                break;
            case 6:
                board.board[1][5] = sign;
                break;
            case 7:
                board.board[2][1] = sign;
                break;
            case 8:
                board.board[2][3] = sign;
                break;
            case 9:
                board.board[2][5] = sign;
                break;
            default:
                break;
        }
    }
}
