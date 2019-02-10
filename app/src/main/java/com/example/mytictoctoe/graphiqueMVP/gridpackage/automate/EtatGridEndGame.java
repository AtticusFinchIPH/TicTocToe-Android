package com.example.mytictoctoe.graphiqueMVP.gridpackage.automate;

import com.example.mytictoctoe.graphiqueMVP.gridpackage.ModelGrid;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.PresentationGrid;

import java.util.logging.Logger;

public class EtatGridEndGame extends AbstractEtatGrid {

    private Logger LOGGER = Logger.getLogger(EtatGridEndGame.class.getName());

    public EtatGridEndGame(PresentationGrid pres, ModelGrid mod){
        super(pres, mod);
    }

    @Override
    public void pressButton() throws GridException {
        presGrid.setEtatCourant(presGrid.getEtatInGame());
        LOGGER.info("Passage to EtatGridInGame");
    }
}
