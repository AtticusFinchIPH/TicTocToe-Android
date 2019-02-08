package com.example.mytictoctoe.graphiqueMVP.gridpackage.automate;

import java.util.logging.Logger;

public class EtatGridInGame extends AbstractEtatGrid {
    private Logger LOGGER = Logger.getLogger(EtatGridInGame.class.getName());

    public EtatGridInGame(){
        super();
    }

    @Override
    public void endgame() throws GridException {
        presGrid.setEtatCourant(presGrid.getEtatEndGame());
        LOGGER.info("Passage to EtatGridEndGame");
    }
}
