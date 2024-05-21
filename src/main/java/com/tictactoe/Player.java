package com.tictactoe;

public record Player(char sign) {

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
