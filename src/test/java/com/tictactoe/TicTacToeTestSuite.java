package com.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTestSuite {

    TicTacToeTheGame ticTacToe = new TicTacToeTheGame();

    @Test
    void rowOWinTest() {
        // given
        Player activePlayer = new Player('O');
        int row = 0;
        Board board = new Board();
        board.setSign('O', 0, 0);
        board.setSign('O', 0, 1);
        board.setSign('O', 0, 2);
        board.setSign('X', 1, 0);
        board.setSign('X', 1, 1);
        board.setSign('O', 1, 2);
        board.setSign('O', 2, 0);
        board.setSign('X', 2, 1);
        board.setSign('X', 2, 2);
        board.printBoard();
        WinnerChecker winnerChecker = new WinnerChecker(board);

        // when
        boolean result = winnerChecker.rowWinCheck(board, activePlayer, row);

        // then
        assertTrue(result);
    }

    @Test
    void colOWinTest() {
        // given
        Player activePlayer = new Player('O');
        int col = 0;
        Board board = new Board();
        board.setSign('O', 0, 0);
        board.setSign('O', 0, 1);
        board.setSign('X', 0, 2);
        board.setSign('O', 1, 0);
        board.setSign('O', 1, 1);
        board.setSign('X', 1, 2);
        board.setSign('O', 2, 0);
        board.setSign('X', 2, 1);
        board.setSign('O', 2, 2);
        board.printBoard();
        WinnerChecker winnerChecker = new WinnerChecker(board);

        // when
        boolean result = winnerChecker.colWinCheck(board, activePlayer, col);

        // then
        assertTrue(result);
    }

    @Test
    void leftCrossOWinTest() {
        // given
        Player activePlayer = new Player('O');
        int row = 0;
        Board board = new Board();
        board.setSign('O', 0, 0);
        board.setSign('X', 0, 1);
        board.setSign('O', 0, 2);
        board.setSign('X', 1, 0);
        board.setSign('O', 1, 1);
        board.setSign('O', 1, 2);
        board.setSign('X', 2, 0);
        board.setSign('X', 2, 1);
        board.setSign('O', 2, 2);
        board.printBoard();
        WinnerChecker winnerChecker = new WinnerChecker(board);

        // when
        boolean result = winnerChecker.leftCrossWinCheck(board, activePlayer);

        // then
        assertTrue(result);
    }

    @Test
    void rightCrossOWinTest() {
        // given
        Player activePlayer = new Player('O');
        int row = 0;
        Board board = new Board();
        board.setSign('X', 0, 0);
        board.setSign('X', 0, 1);
        board.setSign('O', 0, 2);
        board.setSign('X', 1, 0);
        board.setSign('O', 1, 1);
        board.setSign('O', 1, 2);
        board.setSign('O', 2, 0);
        board.setSign('O', 2, 1);
        board.setSign('X', 2, 2);
        board.printBoard();
        WinnerChecker winnerChecker = new WinnerChecker(board);

        // when
        boolean result = winnerChecker.rightCrossWinCheck(board, activePlayer);

        // then
        assertTrue(result);
    }

    @Test
    void rowXWinTest() {
        // given
        Player activePlayer = new Player('X');
        int row = 0;
        Board board = new Board();
        board.setSign('X', 0, 0);
        board.setSign('X', 0, 1);
        board.setSign('X', 0, 2);
        board.setSign('X', 1, 0);
        board.setSign('O', 1, 1);
        board.setSign('O', 1, 2);
        board.setSign('O', 2, 0);
        board.setSign('X', 2, 1);
        board.setSign('O', 2, 2);
        board.printBoard();
        WinnerChecker winnerChecker = new WinnerChecker(board);

        // when
        boolean result = winnerChecker.rowWinCheck(board, activePlayer, row);

        // then
        assertTrue(result);
    }

    @Test
    void colXWinTest() {
        // given
        Player activePlayer = new Player('X');
        int col = 0;
        Board board = new Board();
        board.setSign('X', 0, 0);
        board.setSign('X', 0, 1);
        board.setSign('O', 0, 2);
        board.setSign('X', 1, 0);
        board.setSign('O', 1, 1);
        board.setSign('X', 1, 2);
        board.setSign('X', 2, 0);
        board.setSign('O', 2, 1);
        board.setSign('O', 2, 2);
        board.printBoard();
        WinnerChecker winnerChecker = new WinnerChecker(board);

        // when
        boolean result = winnerChecker.colWinCheck(board, activePlayer, col);

        // then
        assertTrue(result);
    }

    @Test
    void leftCrossXWinTest() {
        // given
        Player activePlayer = new Player('X');
        int row = 0;
        Board board = new Board();
        board.setSign('X', 0, 0);
        board.setSign('X', 0, 1);
        board.setSign('O', 0, 2);
        board.setSign('O', 1, 0);
        board.setSign('X', 1, 1);
        board.setSign('O', 1, 2);
        board.setSign('O', 2, 0);
        board.setSign('0', 2, 1);
        board.setSign('X', 2, 2);
        board.printBoard();
        WinnerChecker winnerChecker = new WinnerChecker(board);

        // when
        boolean result = winnerChecker.leftCrossWinCheck(board, activePlayer);

        // then
        assertTrue(result);
    }

    @Test
    void rightCrossXWinTest() {
        // given
        Player activePlayer = new Player('X');
        int row = 0;
        Board board = new Board();
        board.setSign('O', 0, 0);
        board.setSign('X', 0, 1);
        board.setSign('X', 0, 2);
        board.setSign('X', 1, 0);
        board.setSign('X', 1, 1);
        board.setSign('O', 1, 2);
        board.setSign('X', 2, 0);
        board.setSign('O', 2, 1);
        board.setSign('O', 2, 2);
        board.printBoard();
        WinnerChecker winnerChecker = new WinnerChecker(board);

        // when
        boolean result = winnerChecker.rightCrossWinCheck(board, activePlayer);

        // then
        assertTrue(result);
    }


    @Test
    void drawTest() {
        // given
        WinnerChecker winnerChecker = new WinnerChecker(new Board());
        int counter = 9;

        // when
        boolean result = winnerChecker.checkTheDraw(counter);

        // then
        assertTrue(result);
    }

    @Test
    void exceptionThrowTest() {
        // given
        Board board = new Board();
        board.setSign('X', 0, 0);

        // when & then
        assertThrows(Exception.class, () -> board.isFieldEmpty(0, 0));
    }
}
