package com.example.mytictoctoe.graphiqueMVP.gridpackage;

import android.util.Log;

import com.example.mytictoctoe.graphiqueMVP.globalpackage.PresentationGlobal;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.automate.EtatGridEndGame;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.automate.EtatGridInGame;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.automate.EtatGridSwitchPlayer;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.automate.GridException;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.automate.IEtatGrid;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfGlobal;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfGrid;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfSquare;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.PresentationSquare;

import java.util.ArrayList;
import java.util.List;

public class PresentationGrid implements IObserverOfGlobal, IObserverOfSquare {

    private IViewGrid viewGrid;
    private ModelGrid modelGrid;

    private PresentationGlobal presGlobal;
    private PresentationSquare presSquare;

    // Etats
    private IEtatGrid etatCourant;
    private IEtatGrid etatInGame;
    private IEtatGrid etatSwitchPlayer;
    private IEtatGrid etatEndGame;

    // Observers of Button
    private List<IObserverOfGrid> observers = new ArrayList<IObserverOfGrid>();

    public PresentationGrid (){

        etatInGame = new EtatGridInGame(this, modelGrid);
        etatSwitchPlayer = new EtatGridSwitchPlayer(this, modelGrid);
        etatEndGame = new EtatGridEndGame(this, modelGrid);
        etatCourant = etatEndGame;
    }

    // Point to IViewGrid
    public void setViewGrid(IViewGrid viewGrid) {
        this.viewGrid = viewGrid;
    }

    public ModelGrid getModelGrid() {
        return modelGrid;
    }

    // Methods for Observer Pattern
    public void  attach(IObserverOfGrid observer){
        observers.add(observer);
    }

    public  void notifAllObservers() {
        for (IObserverOfGrid observer : observers){
            observer.updateFromGrid();
        }
    }

    // Notification from Global part
    @Override
    public void updateFromGlobal() {
        if(presGlobal.getEtatCourant().equals(presGlobal.getEtatEnableButton())){
            try {
                etatCourant.pressButton();
            } catch (GridException e){
            }
            notifAllObservers();
        } else if(presGlobal.getEtatCourant().equals(presGlobal.getEtatDisableButton())) {
            try {
                etatCourant.endgame();
            } catch (GridException e){
            }
            notifAllObservers();
        } else  {
            Log.d("EtatGlobal", "EtatGlobal Error!!!");
        }

    }

    @Override
    public void subscribeToGlobal(PresentationGlobal subject) {
        presGlobal = subject;
        presGlobal.attach(this);
    }

    // Notification from Square part
    @Override
    public void updateFromSquare() {
        // TODO
        try {
            etatCourant.switchPlayer();
        } catch (GridException e){
        }
        notifAllObservers();
    }

    @Override
    public void subscribeToSquare(PresentationSquare subject) {
        presSquare = subject;
        presSquare.attach(this);
    }

    //----------Gestion Automate + Facade
    public void setEtatCourant(final IEtatGrid e) {
        etatCourant = e;
    }

    public IEtatGrid getEtatCourant() {
        return etatCourant;
    }

    public IEtatGrid getEtatInGame(){
        return etatInGame;
    }

    public IEtatGrid getEtatSwitchPlayer() {
        return etatSwitchPlayer;
    }

    public IEtatGrid getEtatEndGame() {
        return etatEndGame;
    }


}
