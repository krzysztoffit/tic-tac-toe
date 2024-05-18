package com.tictactoe;

public class Player {

    private char sign;

    public Player(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;
        return sign == player.sign;
    }

    @Override
    public int hashCode() {
        return sign;
    }
}
