package com.example.mytictoctoe.graphiqueMVP.squarepackage.automate;

import com.example.mytictoctoe.graphiqueMVP.squarepackage.PresentationSquare;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.ModelSquare;

public abstract class AbstractEtatSquare implements IEtatSquare {

    protected PresentationSquare presSquare;
    protected ModelSquare modelSquare;

    public AbstractEtatSquare(final PresentationSquare pres, ModelSquare mod){
        presSquare = pres;
        modelSquare = mod;
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
