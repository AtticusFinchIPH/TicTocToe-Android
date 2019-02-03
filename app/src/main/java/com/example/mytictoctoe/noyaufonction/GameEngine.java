package com.example.mytictoctoe.noyaufonction;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    private Grid grid;
    private boolean isEnded;
    private List<Player> playerList;
    private Player currentPlayer;

    public GameEngine() {
        grid = new Grid();
        playerList = new ArrayList<Player>(2);
        playerList.get(0).setCharacter('O');
        playerList.get(1).setCharacter('X');
        setCurrentPlayer(playerList.get(0));
        playGame();
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }

    private void newGame(){
        for (Square square : grid.getSquares()) {
            square.setCharacter(' ');
        }
        setCurrentPlayer(playerList.get(0));
        setEnded(false);
    }

    public void playGame() {

    }

    public boolean isEnded() {
        return isEnded;
    }

    private void setEnded(boolean isEnded){
        this.isEnded = isEnded;
    }
}
