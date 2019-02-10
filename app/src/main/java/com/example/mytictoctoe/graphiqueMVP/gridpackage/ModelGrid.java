package com.example.mytictoctoe.graphiqueMVP.gridpackage;

public class ModelGrid {

    private char currentCharacter;

    public ModelGrid(){
        currentCharacter = 'O';
    }

    public void switchCharacter(){
        if(currentCharacter == 'O'){
            currentCharacter = 'X';
        } else if (currentCharacter == 'X'){
            currentCharacter = 'O';
        } else {
            System.out.printf("Character Error!!!");
        }
    }

    public char getCurrentCharacter() {
        return currentCharacter;
    }
}
