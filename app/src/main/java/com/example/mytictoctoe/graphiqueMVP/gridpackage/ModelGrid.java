package com.example.mytictoctoe.graphiqueMVP.gridpackage;

public class ModelGrid {

    private char currentCharacter;
    private char recentCharacter;
    private int recentSquare;

    public ModelGrid(){
        recentCharacter = 'O';
        currentCharacter = 'O';
    }

    public void switchCharacter(){
        recentCharacter = currentCharacter;
        if(currentCharacter == 'O'){
            currentCharacter = 'X';
        } else if (currentCharacter == 'X'){
            currentCharacter = 'O';
        } else {
            System.out.printf("Character Error!!!");
        }
    }

    public char getRecentCharacter() {
        return recentCharacter;
    }

    public char getCurrentCharacter() {
        return currentCharacter;
    }

    public void setRecentSquare(int recentSquare) {
        this.recentSquare = recentSquare;
    }

    public int getRecentSquare() {
        return recentSquare;
    }
}
