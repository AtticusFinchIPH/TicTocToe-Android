package com.example.mytictoctoe.graphiqueMVP.gridpackage.automate;

import com.example.mytictoctoe.graphiqueMVP.gridpackage.ModelGrid;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.PresentationGrid;

import java.util.logging.Logger;

public class EtatGridSwitchPlayer extends AbstractEtatGrid {
    private Logger LOGGER = Logger.getLogger(EtatGridSwitchPlayer.class.getName());

    public EtatGridSwitchPlayer(PresentationGrid pres, ModelGrid mod){
        super(pres, mod);
    }

    @Override
    public void switchPlayer() throws GridException {
        modelGrid.switchCharacter();
    }

    @Override
    public void endgame() throws GridException {
        presGrid.setEtatCourant(presGrid.getEtatEndGame());
        LOGGER.info("Passage to EtatGridEndGame");
    }
}
