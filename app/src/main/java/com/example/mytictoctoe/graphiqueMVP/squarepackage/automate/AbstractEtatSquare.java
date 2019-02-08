package com.example.mytictoctoe.graphiqueMVP.squarepackage.automate;

import com.example.mytictoctoe.graphiqueMVP.globalpackage.automate.AbstractEtatGlobal;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.PresentationSquare;

public abstract class AbstractEtatSquare implements IEtatSquare {

    protected PresentationSquare presSquare;

    public AbstractEtatSquare(final PresentationSquare pres){
        presSquare = pres;
    }

    @Override
    public void newgame() throws SquareException{
        throw new SquareException();
    }

    @Override
    public void endgame()  throws SquareException{
        throw new SquareException();
    }

    @Override
    public void choose() throws SquareException{
        throw new SquareException();
    }
}
