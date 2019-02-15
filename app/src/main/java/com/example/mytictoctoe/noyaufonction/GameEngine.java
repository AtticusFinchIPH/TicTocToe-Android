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
        isEnded = false;
        playerList = new ArrayList<Player>(2);
        playerList.get(0).setCharacter('O');
        playerList.get(1).setCharacter('X');
        setCurrentPlayer(playerList.get(0));
        newGame();
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void changePlayer(){
        currentPlayer = (currentPlayer.getCharacter() == 'X' ? playerList.get(0) : playerList.get(1));
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

    public void choose(int pos) {
        if(!isEnded && grid.getSquares().get(pos).getCharacter() == ' '){
            grid.getSquares().get(pos).setCharacter(currentPlayer.getCharacter());
            if(grid.checkWinner()== ' ') changePlayer();
            else if(grid.checkWinner()== currentPlayer.getCharacter()) setEnded(true);
            else if(grid.checkWinner()== 'N') {
                currentPlayer.setCharacter('N');
                setEnded(true);
            }
        }
    }

    public boolean isEnded() {
        return isEnded;
    }

    private void setEnded(boolean isEnded){
        this.isEnded = isEnded;
    }
}
