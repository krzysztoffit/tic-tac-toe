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

            try {
                if (board.isFieldEmpty(row, col)) {
                    board.setSign(activePlayer.sign(), row, col);
                    counter++;
                    if (checkTheWin(activePlayer, row, col)) {
                        break;
                    } else if (checkTheDraw(counter)) {
                        break;
                    }
                    if (xPlayer.equals(activePlayer)) {
                        activePlayer = oPlayer;
                    } else {
                        activePlayer = xPlayer;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean checkTheWin(Player activePlayer, int row, int col) {
        return rowWinCheck(board, activePlayer, row)
                || colWinCheck(board, activePlayer, col)
                || leftCrossWinCheck(board, activePlayer)
                || rightCrossWinCheck(board, activePlayer);
    }

    public boolean rowWinCheck(Board board, Player activePlayer, int row) {
        int signCounter = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSign(row, i) == activePlayer.sign()) {
                signCounter++;
            }
            if (whoWins(signCounter, activePlayer.sign())) return true;
        }
        return false;
    }

    public boolean colWinCheck(Board board, Player activePlayer, int col) {
        int signCounter = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSign(i, col) == activePlayer.sign()) {
                signCounter++;
            }
            if (whoWins(signCounter, activePlayer.sign())) return true;
        }
        return false;
    }

    public boolean leftCrossWinCheck(Board board, Player activePlayer) {
        int signCounter = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSign(i, i) == activePlayer.sign()) {
                signCounter++;
            }
            if (whoWins(signCounter, activePlayer.sign())) return true;
        }
        return false;
    }

    public boolean rightCrossWinCheck(Board board, Player activePlayer) {
        int signCounter = 0;
        int colMax = 2;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSign(i, colMax) == activePlayer.sign()) {
                signCounter++;
            }
            if (whoWins(signCounter, activePlayer.sign())) return true;
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

    public boolean checkTheDraw(int counter) {
        if (counter == 9) {
            System.out.println("It's a draw!");
            return true;
        }
        return false;
    }
}
