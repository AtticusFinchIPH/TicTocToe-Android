package com.example.mytictoctoe.graphiqueMVP.squarepackage.automate;

import com.example.mytictoctoe.graphiqueMVP.squarepackage.PresentationSquare;

import java.util.logging.Logger;

public class EtatFilledSquare extends AbstractEtatSquare {
    private Logger LOGGER = Logger.getLogger(EtatFilledSquare.class.getName());

    public EtatFilledSquare(PresentationSquare pres){
        super(pres);
    }

    @Override
    public void endgame() throws SquareException {
        presSquare.setEtatCourant(presSquare.getEtatDisableSquare());
        LOGGER.info("Passage to EtatDisableSquare");
    }
}
