package com.example.mytictoctoe.graphiqueMVP.globalpackage.automate;

import com.example.mytictoctoe.graphiqueMVP.globalpackage.ModelGlobal;
import com.example.mytictoctoe.graphiqueMVP.globalpackage.PresentationGlobal;

public abstract class AbstractEtatGlobal implements IEtatGlobal {

    protected PresentationGlobal presGlobal;
    protected ModelGlobal modelGlobal;

    public AbstractEtatGlobal (final PresentationGlobal pres, final ModelGlobal mod){
        presGlobal = pres;
        modelGlobal = mod;
    }

    @Override
    public void newgame() throws ButtonException{
        throw new ButtonException();
    }

    @Override
    public void endgame() throws ButtonException{
        throw new ButtonException();
    }
}
