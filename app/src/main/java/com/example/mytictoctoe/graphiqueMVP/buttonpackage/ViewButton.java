package com.example.mytictoctoe.graphiqueMVP.buttonpackage;

import android.widget.Button;

public class ViewButton implements IViewButton {

    private PresentationButton presButton;

    private Button playButton;

    public ViewButton(final PresentationButton pres, Button button){
        presButton = pres;
        playButton = button;
        //playButton.setOnClickListener();
    }

    @Override
    public void notifStartGame() {

    }
}
