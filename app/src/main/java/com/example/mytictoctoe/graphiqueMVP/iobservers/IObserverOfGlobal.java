package com.example.mytictoctoe.graphiqueMVP.iobservers;

import com.example.mytictoctoe.graphiqueMVP.globalpackage.PresentationGlobal;

public interface IObserverOfGlobal {

    public void updateFromGlobal();
    public void subscribeToGlobal(PresentationGlobal subject);
}
