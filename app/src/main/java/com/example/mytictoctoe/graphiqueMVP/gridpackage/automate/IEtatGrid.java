package com.example.mytictoctoe.graphiqueMVP.gridpackage.automate;

public interface IEtatGrid {
    void endgame() throws GridException;
    void pressButton() throws GridException;
    void switchPlayer() throws GridException;
}
