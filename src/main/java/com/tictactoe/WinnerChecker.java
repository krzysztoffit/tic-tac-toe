package com.tictactoe;

public class WinnerChecker {

    private final Board board;

    public WinnerChecker(Board board) {
        this.board = board;
    }

    public boolean checkTheWin(Player activePlayer, int row, int col) {
        return rowWinCheck(activePlayer, row)
                || colWinCheck(activePlayer, col)
                || leftCrossWinCheck(activePlayer)
                || rightCrossWinCheck(activePlayer);
    }

    public boolean rowWinCheck(Player activePlayer, int row) {
        int signCounter = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSign(row, i) == activePlayer.sign()) {
                signCounter++;
            }
            if (whoWins(signCounter, activePlayer.sign())) return true;
        }
        return false;
    }

    public boolean colWinCheck(Player activePlayer, int col) {
        int signCounter = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSign(i, col) == activePlayer.sign()) {
                signCounter++;
            }
            if (whoWins(signCounter, activePlayer.sign())) return true;
        }
        return false;
    }

    public boolean leftCrossWinCheck(Player activePlayer) {
        int signCounter = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSign(i, i) == activePlayer.sign()) {
                signCounter++;
            }
            if (whoWins(signCounter, activePlayer.sign())) return true;
        }
        return false;
    }

    public boolean rightCrossWinCheck(Player activePlayer) {
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
