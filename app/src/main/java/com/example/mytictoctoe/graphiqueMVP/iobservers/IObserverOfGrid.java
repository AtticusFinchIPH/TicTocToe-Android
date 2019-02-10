package com.example.mytictoctoe.graphiqueMVP.iobservers;

import com.example.mytictoctoe.graphiqueMVP.gridpackage.PresentationGrid;

public interface IObserverOfGrid {

    public void updateFromGrid();
    public void subscribeToGrid(PresentationGrid subject);
}
