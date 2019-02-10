package com.example.mytictoctoe.graphiqueMVP.globalpackage;

public class ModelGlobal {

    private String infoString;
    private char currentplayer;
    private  boolean clickable;

    public ModelGlobal() {
        clickable = true;
    }

    public void setInfoString(String infoString) {
        this.infoString = infoString;
    }

    public String getInfoString() {
        return infoString;
    }

    public void setCurrentplayer(char currentplayer) {
        this.currentplayer = currentplayer;
    }

    public char getCurrentplayer() {
        return currentplayer;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean isClickable() {
        return clickable;
    }
}
