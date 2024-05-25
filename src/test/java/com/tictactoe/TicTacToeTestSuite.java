package com.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTestSuite {

    TicTacToeTheGame ticTacToe = new TicTacToeTheGame();

    public Board boardMaker(Player activePlayer) {
        Board board = new Board();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board.setSign(activePlayer.sign(), row, col);
            }
        }
        return board;
    }


    @Test
    void rowOWinTest() {
        // given
        Player activePlayer = new Player('O');
        int row = 0;
        Board board = boardMaker(activePlayer);

        // when
        boolean result = ticTacToe.rowWinCheck(board, activePlayer, row);

        // then
        assertTrue(result);
    }

    @Test
    void colOWinTest() {
        // given
        Player activePlayer = new Player('O');
        int col = 0;
        Board board = boardMaker(activePlayer);

        // when
        boolean result = ticTacToe.colWinCheck(board, activePlayer, col);

        // then
        assertTrue(result);
    }

    @Test
    void leftCrossOWinTest() {
        // given
        Player activePlayer = new Player('O');
        int row = 0;
        Board board = boardMaker(activePlayer);

        // when
        boolean result = ticTacToe.leftCrossWinCheck(board, activePlayer);

        // then
        assertTrue(result);
    }

@Test
    void rightCrossOWinTest() {
        // given
        Player activePlayer = new Player('O');
        int row = 0;
        Board board = boardMaker(activePlayer);

        // when
        boolean result = ticTacToe.rightCrossWinCheck(board, activePlayer);

        // then
        assertTrue(result);
    }

    @Test
    void rowXWinTest() {
        // given
        Player activePlayer = new Player('X');
        int row = 0;
        Board board = boardMaker(activePlayer);

        // when
        boolean result = ticTacToe.rowWinCheck(board, activePlayer, row);

        // then
        assertTrue(result);
    }

    @Test
    void colXWinTest() {
        // given
        Player activePlayer = new Player('X');
        int col = 0;
        Board board = boardMaker(activePlayer);

        // when
        boolean result = ticTacToe.colWinCheck(board, activePlayer, col);

        // then
        assertTrue(result);
    }

    @Test
    void leftCrossXWinTest() {
        // given
        Player activePlayer = new Player('X');
        int row = 0;
        Board board = boardMaker(activePlayer);

        // when
        boolean result = ticTacToe.leftCrossWinCheck(board, activePlayer);

        // then
        assertTrue(result);
    }

    @Test
    void rightCrossXWinTest() {
        // given
        Player activePlayer = new Player('X');
        int row = 0;
        Board board = boardMaker(activePlayer);

        // when
        boolean result = ticTacToe.rightCrossWinCheck(board, activePlayer);

        // then
        assertTrue(result);
    }


    @Test
    void drawTest() {
        // given
        int counter = 9;

        // when
        boolean result = ticTacToe.checkTheDraw(counter);

        // then
        assertTrue(result);
    }

    @Test
    void exceptionThrowTest() {

    }
}
