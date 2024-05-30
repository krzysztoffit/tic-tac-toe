package com.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeTheGame {

    private static final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private Board board;
    private final Player xPlayer = new Player('X');
    private final Player oPlayer = new Player('O');

    public void playTheGame() {
        Player activePlayer = xPlayer;
        int counter = 0;
        int col;
        int row;

        boardSizeChoose();

        while (true) {
            if (oPlayer.equals(activePlayer)) {
                row = random.nextInt(board.getSize());
                col = random.nextInt(board.getSize());
                System.out.println("Computer chosen row " + (row + 1) + " and column " + (col + 1));
                try {
                    if (board.isFieldEmpty(row, col)) {
                        board.setSign(activePlayer.sign(), row, col);
                        counter++;
                        if (checkTheWin(activePlayer, row, col)) {
                            break;
                        } else if (checkTheDraw(counter)) {
                            break;
                        }
                        activePlayer = xPlayer;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
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
                        activePlayer = oPlayer;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }

    private boolean boardSizeChoose() {
        int boardSize = 0;
        while (true) {
            System.out.print("Choose size of the board (3, 10): ");
            boardSize = scanner.nextInt();
            if (boardSize == 3) {
                board = new Board();
                return false;
            } else if (boardSize == 10) {
                board = new Board10();
                return false;
            } else {
                System.out.println("There is no such option. Try again.");
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
        int colMax = board.getSize() - 1;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSign(i, colMax) == activePlayer.sign()) {
                signCounter++;
            }
            if (whoWins(signCounter, activePlayer.sign())) return true;
            colMax--;
        }
        return false;
    }

    private boolean whoWins(int signCounter, char sign) {
        if (signCounter == board.winCondition()) {
            System.out.println("Player " + sign + " wins!");
            return true;
        }
        return false;
    }

    public boolean checkTheDraw(int counter) {
        if (counter == (board.getSize() * board.getSize())) {
            System.out.println("It's a draw!");
            return true;
        }
        return false;
    }
}
