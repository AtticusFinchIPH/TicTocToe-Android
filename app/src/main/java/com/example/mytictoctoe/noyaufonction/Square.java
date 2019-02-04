package com.example.mytictoctoe.noyaufonction;

public class Square {

    private int position;
    private static char character;
    private boolean isAccessible;

    public Square() {
        character = ' ';
    }

    public Square(int p) {
        position = p;
        character = ' ';
    }

    public Square(int p, char c) {
        position = p;
        character = c;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setCharacter(char character) {
        Square.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public void setAccesible(boolean a){
        isAccessible = a;
    }

    public boolean isAccessible() {
        return isAccessible;
    }
}
