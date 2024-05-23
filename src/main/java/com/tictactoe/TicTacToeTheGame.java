package com.tictactoe;

import java.util.Scanner;

public class TicTacToeTheGame {

    private static final Scanner scanner = new Scanner(System.in);
    private final Board board = new Board();
    private final Player xPlayer = new Player('X');
    private final Player oPlayer = new Player('O');

    public void playTheGame() {
        Player activePlayer = xPlayer;
        int counter = 0;
        int col;
        int row;

        while (true) {
            board.printBoard();
            System.out.println("Player " + activePlayer.sign() + " it's your move.");
            System.out.print("Choose row: ");
            row = scanner.nextInt() - 1;
            System.out.print("Choose column: ");
            col = scanner.nextInt() - 1;

            if (board.isFieldEmpty(row, col)) {
                board.setSign(activePlayer.sign(), row, col);
                counter++;
                if (checkTheWin(activePlayer, row, col)) {
                    break;
                } else if (counter == 9) {
                    System.out.println("It's a draw!");
                    break;
                }
                if (xPlayer.equals(activePlayer)) {
                    activePlayer = oPlayer;
                } else {
                    activePlayer = xPlayer;
                }
            } else {
                System.out.println("The field is not empty! Try again.");
            }
        }
    }

    public boolean checkTheWin(Player activePlayer, int row, int col) {
        char sign = activePlayer.sign();
        return rowWinCheck(activePlayer, row, sign)
                || colWinCheck(activePlayer, col, sign)
                || leftCrossWinCheck(activePlayer, sign)
                || rightCrossWinCheck(activePlayer, sign);
    }

    private boolean rowWinCheck(Player activePlayer, int row, char sign) {
        int signCounter = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSign(row, i) == activePlayer.sign()) {
                signCounter++;
            }
            if (whoWins(signCounter, sign)) return true;
        }
        return false;
    }

    private boolean colWinCheck(Player activePlayer, int col, char sign) {
        int signCounter = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSign(i, col) == activePlayer.sign()) {
                signCounter++;
            }
            if (whoWins(signCounter, sign)) return true;
        }
        return false;
    }

    private boolean leftCrossWinCheck(Player activePlayer, char sign) {
        int signCounter = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSign(i, i) == activePlayer.sign()) {
                signCounter++;
            }
            if (whoWins(signCounter, sign)) return true;
        }
        return false;
    }

    private boolean rightCrossWinCheck(Player activePlayer, char sign) {
        int signCounter = 0;
        int colMax = 2;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSign(i, colMax) == activePlayer.sign()) {
                signCounter++;
            }
            if (whoWins(signCounter, sign)) return true;
            colMax--;
        }
        return false;
    }

    private static boolean whoWins(int signCounter, char sign) {
        if (signCounter == 3) {
            System.out.println("Player " + sign + " wins!");
            return true;
        }
        return false;
    }
}
