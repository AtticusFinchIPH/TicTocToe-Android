package com.example.mytictoctoe.graphiqueMVP.buttonpackage;

public class ModelButton {

    private  boolean clickable;

    public ModelButton() {
        clickable = true;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean isClickable() {
        return clickable;
    }
}
