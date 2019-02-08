package com.example.mytictoctoe.graphiqueMVP.gridpackage.automate;

import java.util.logging.Logger;

public class EtatGridEndGame extends AbstractEtatGrid {

    private Logger LOGGER = Logger.getLogger(EtatGridEndGame.class.getName());

    public EtatGridEndGame(){
        super();
    }

    @Override
    public void pressButton() throws GridException {
        presGrid.setEtatCourant(presGrid.getEtatInGame());
        LOGGER.info("Passage to EtatGridInGame");
    }
}
