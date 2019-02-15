package com.example.mytictoctoe.graphiqueMVP.squarepackage.automate;

import com.example.mytictoctoe.graphiqueMVP.squarepackage.PresentationSquare;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.ModelSquare;

import java.util.logging.Logger;

public class EtatDisableSquare extends AbstractEtatSquare {

    private Logger LOGGER = Logger.getLogger(EtatDisableSquare.class.getName());

    public EtatDisableSquare(PresentationSquare pres, ModelSquare mod){
        super(pres, mod);
    }

    @Override
    public void newgame() throws SquareException {
        presSquare.setEtatCourant(presSquare.getEtatEmptySquare());
        modelSquare.setCharacter(' ');
        LOGGER.info("Passage to EtatEmptySquare");
    }
}
