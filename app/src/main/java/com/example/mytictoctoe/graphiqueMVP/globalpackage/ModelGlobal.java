package com.example.mytictoctoe.graphiqueMVP.globalpackage;

public class ModelGlobal {

    private  boolean clickable;

    public ModelGlobal() {
        clickable = true;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean isClickable() {
        return clickable;
    }
}
