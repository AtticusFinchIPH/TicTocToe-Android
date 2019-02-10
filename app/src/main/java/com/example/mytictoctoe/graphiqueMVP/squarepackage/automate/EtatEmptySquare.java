package com.example.mytictoctoe.graphiqueMVP.squarepackage.automate;

import com.example.mytictoctoe.graphiqueMVP.squarepackage.PresentationSquare;

import java.util.logging.Logger;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.ModelSquare;

public class EtatEmptySquare extends AbstractEtatSquare {
    private Logger LOGGER = Logger.getLogger(EtatEmptySquare.class.getName());

    public EtatEmptySquare(PresentationSquare pres, ModelSquare mod){
        super(pres, mod);
    }

    @Override
    public void endgame() throws SquareException {
        presSquare.setEtatCourant(presSquare.getEtatDisableSquare());
        LOGGER.info("Passage to EtatDisableSquare");
    }

    @Override
    public void choose() throws SquareException {
        presSquare.setEtatCourant(presSquare.getEtatFilledSquare());
        LOGGER.info("Passage to EtatFilledSquare");
    }
}
