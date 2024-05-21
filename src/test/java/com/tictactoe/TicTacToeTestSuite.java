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
        int col = 0;
        Board board = new Board();
        board.board[row][col] = activePlayer.sign();
        board.board[0][1] = activePlayer.sign();
        board.board[0][2] = activePlayer.sign();

        // when
        boolean result = ticTacToe.checkTheWin(activePlayer, row, col, board);

        // then
        assertTrue(result);
    }

    @Test
    void colOWinTest() {
        // given
        Player activePlayer = new Player('O');
        int row = 0;
        int col = 0;
        Board board = new Board();
        board.board[row][col] = activePlayer.sign();
        board.board[1][0] = activePlayer.sign();
        board.board[2][0] = activePlayer.sign();

        // when
        boolean result = ticTacToe.checkTheWin(activePlayer, row, col, board);

        // then
        assertTrue(result);
    }

    @Test
    void crossOWinTest() {
        // given
        Player activePlayer = new Player('O');
        int row = 0;
        int col = 0;
        Board board = new Board();
        board.board[row][col] = activePlayer.sign();
        board.board[1][1] = activePlayer.sign();
        board.board[2][2] = activePlayer.sign();

        // when
        boolean result = ticTacToe.checkTheWin(activePlayer, row, col, board);

        // then
        assertTrue(result);
    }

    @Test
    void rowXWinTest() {
        // given
        Player activePlayer = new Player('X');
        int row = 0;
        int col = 0;
        Board board = new Board();
        board.board[row][col] = activePlayer.sign();
        board.board[0][1] = activePlayer.sign();
        board.board[0][2] = activePlayer.sign();

        // when
        boolean result = ticTacToe.checkTheWin(activePlayer, row, col, board);

        // then
        assertTrue(result);
    }

    @Test
    void colXWinTets() {
        // given
        Player activePlayer = new Player('X');
        int row = 0;
        int col = 0;
        Board board = new Board();
        board.board[row][col] = activePlayer.sign();
        board.board[1][0] = activePlayer.sign();
        board.board[2][0] = activePlayer.sign();

        // when
        boolean result = ticTacToe.checkTheWin(activePlayer, row, col, board);

        // then
        assertTrue(result);
    }

    @Test
    void crossXWinTest() {
        // given
        Player activePlayer = new Player('X');
        int row = 0;
        int col = 0;
        Board board = new Board();
        board.board[row][col] = activePlayer.sign();
        board.board[1][1] = activePlayer.sign();
        board.board[2][2] = activePlayer.sign();

        // when
        boolean result = ticTacToe.checkTheWin(activePlayer, row, col, board);

        // then
        assertTrue(result);
    }

    @Test
    void drawTest() {
        // given
        boolean gameOver = false;

        // when
        boolean result = ticTacToe.checkTheDraw(9, gameOver);

        // then
        assertTrue(result);
    }

    @Test
    void exceptionThrowTest() {

    }
}
