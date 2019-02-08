package com.example.mytictoctoe.graphiqueMVP.gridpackage.automate;

import com.example.mytictoctoe.graphiqueMVP.globalpackage.automate.AbstractEtatGlobal;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.PresentationGrid;
import com.example.mytictoctoe.noyaufonction.Grid;

public abstract class AbstractEtatGrid implements IEtatGrid{

    protected PresentationGrid presGrid;

    public AbstractEtatGrid(){

    }

    @Override
    public void endgame() throws GridException{
        throw new GridException();
    }

    @Override
    public void pressButton()throws GridException{
        throw new GridException();
    }
}
