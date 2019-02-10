package com.example.mytictoctoe.graphiqueMVP.globalpackage.automate;

import com.example.mytictoctoe.graphiqueMVP.globalpackage.ModelGlobal;
import com.example.mytictoctoe.graphiqueMVP.globalpackage.PresentationGlobal;

import java.util.logging.Logger;

public class EtatEnableGlobal extends AbstractEtatGlobal {
    private Logger LOGGER = Logger.getLogger(EtatEnableGlobal.class.getName());

    public EtatEnableGlobal(PresentationGlobal pres, final ModelGlobal mod){
        super(pres, mod);
    }

    @Override
    public void newgame() throws ButtonException {
        modelGlobal.setClickable(false);
        presGlobal.setEtatCourant(presGlobal.getEtatDisableButton());
        LOGGER.info("Passage to EtatDisableButton");
    }
}
