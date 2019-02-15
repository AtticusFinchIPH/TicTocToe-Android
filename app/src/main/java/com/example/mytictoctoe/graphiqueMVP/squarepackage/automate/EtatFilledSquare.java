package com.example.mytictoctoe.graphiqueMVP.squarepackage.automate;

import com.example.mytictoctoe.graphiqueMVP.squarepackage.PresentationSquare;

import java.util.logging.Logger;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.ModelSquare;

public class EtatFilledSquare extends AbstractEtatSquare {
    private Logger LOGGER = Logger.getLogger(EtatFilledSquare.class.getName());

    public EtatFilledSquare(PresentationSquare pres, ModelSquare mod){
        super(pres, mod);
    }

    @Override
    public void endgame() throws SquareException {
        presSquare.setEtatCourant(presSquare.getEtatDisableSquare());
        modelSquare.setCharacter(' ');
        LOGGER.info("Passage to EtatDisableSquare");
    }
}
