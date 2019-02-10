package com.example.mytictoctoe.graphiqueMVP.globalpackage.automate;

import com.example.mytictoctoe.graphiqueMVP.globalpackage.ModelGlobal;
import com.example.mytictoctoe.graphiqueMVP.globalpackage.PresentationGlobal;

import java.util.logging.Logger;

public class EtatDisableGlobal extends AbstractEtatGlobal {

    private Logger LOGGER = Logger.getLogger(EtatDisableGlobal.class.getName());

    public EtatDisableGlobal(PresentationGlobal pres, final ModelGlobal mod){
        super(pres, mod);
    }

    @Override
    public void endgame() throws ButtonException {
        modelGlobal.setClickable(true);
        presGlobal.setEtatCourant(presGlobal.getEtatEnableButton());
        LOGGER.info("Passage to EtatEnableButton");
    }
}
