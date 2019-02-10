package com.example.mytictoctoe.graphiqueMVP.gridpackage.automate;

import com.example.mytictoctoe.graphiqueMVP.gridpackage.ModelGrid;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.PresentationGrid;

import java.util.logging.Logger;

public class EtatGridInGame extends AbstractEtatGrid {
    private Logger LOGGER = Logger.getLogger(EtatGridInGame.class.getName());

    public EtatGridInGame(PresentationGrid pres, ModelGrid mod){
        super(pres, mod);
    }

    @Override
    public void endgame() throws GridException {
        presGrid.setEtatCourant(presGrid.getEtatEndGame());
        LOGGER.info("Passage to EtatGridEndGame");
    }

    @Override
    public void switchPlayer() throws GridException {
        modelGrid.switchCharacter();
        presGrid.setEtatCourant(presGrid.getEtatSwitchPlayer());
        LOGGER.info("Passage to EtatGridSwitchPlayer");
    }
}
