package com.example.mytictoctoe.graphiqueMVP.squarepackage.automate;

public interface IEtatSquare {
    void newgame() throws SquareException;
    void endgame() throws SquareException;
    void choose() throws SquareException;
}
