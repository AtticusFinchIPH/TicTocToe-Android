package com.example.mytictoctoe.noyaufonction;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private List<Square> squares;

    private Player currentPlayer;
    private List<Player> playerList;

    public Grid() {
        squares = new ArrayList<Square>(9);
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public List<Square> getSquares() {
        return squares;
    }
}
