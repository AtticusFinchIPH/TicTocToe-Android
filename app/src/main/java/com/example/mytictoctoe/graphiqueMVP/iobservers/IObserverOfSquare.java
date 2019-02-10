package com.example.mytictoctoe.graphiqueMVP.iobservers;

import com.example.mytictoctoe.graphiqueMVP.squarepackage.PresentationSquare;

public interface IObserverOfSquare {

    public void updateFromSquare();
    public void subscribeToSquare(PresentationSquare subject);
}
