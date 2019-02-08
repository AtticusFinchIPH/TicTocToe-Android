package com.example.mytictoctoe.graphiqueMVP.squarepackage.automate;

import com.example.mytictoctoe.graphiqueMVP.squarepackage.PresentationSquare;

import java.util.logging.Logger;

public class EtatDisableSquare extends AbstractEtatSquare {

    private Logger LOGGER = Logger.getLogger(EtatDisableSquare.class.getName());

    public EtatDisableSquare(PresentationSquare pres){
        super(pres);
    }

    @Override
    public void newgame() throws SquareException {
        presSquare.setEtatCourant(presSquare.getEtatEmptySquare());
        LOGGER.info("Passage to EtatEmptySquare");
    }
}
