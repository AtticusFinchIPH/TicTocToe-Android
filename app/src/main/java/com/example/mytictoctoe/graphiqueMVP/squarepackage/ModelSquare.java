package com.example.mytictoctoe.graphiqueMVP.squarepackage;

public class ModelSquare {

    private char character;
    private int position;

    public ModelSquare(){
        character = ' ';
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
