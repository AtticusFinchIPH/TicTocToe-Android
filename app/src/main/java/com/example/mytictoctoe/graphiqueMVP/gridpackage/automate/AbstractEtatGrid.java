package com.example.mytictoctoe.graphiqueMVP.gridpackage.automate;

import com.example.mytictoctoe.graphiqueMVP.globalpackage.automate.AbstractEtatGlobal;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.ModelGrid;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.PresentationGrid;
import com.example.mytictoctoe.noyaufonction.Grid;

public abstract class AbstractEtatGrid implements IEtatGrid{

    protected PresentationGrid presGrid;
    protected ModelGrid modelGrid;

    public AbstractEtatGrid(PresentationGrid pres, ModelGrid mod){
        presGrid = pres;
        modelGrid = mod;
    }

    @Override
    public void endgame() throws GridException{
        throw new GridException();
    }

    @Override
    public void pressButton()throws GridException{
        throw new GridException();
    }

    @Override
    public void switchPlayer() throws GridException{
        throw new GridException();
    }
}
