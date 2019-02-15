package com.example.mytictoctoe.graphiqueMVP.globalpackage;

import com.example.mytictoctoe.graphiqueMVP.globalpackage.automate.GlobalException;
import com.example.mytictoctoe.graphiqueMVP.globalpackage.automate.EtatDisableGlobal;
import com.example.mytictoctoe.graphiqueMVP.globalpackage.automate.EtatEnableGlobal;
import com.example.mytictoctoe.graphiqueMVP.globalpackage.automate.IEtatGlobal;
import com.example.mytictoctoe.graphiqueMVP.gridpackage.PresentationGrid;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfGlobal;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfGrid;
import com.example.mytictoctoe.noyaufonction.GameEngine;

import java.util.ArrayList;
import java.util.List;

public class PresentationGlobal implements IObserverOfGrid {

    private IViewGlobal viewGlobal;
    private ModelGlobal modelGlobal;

    private PresentationGrid presGrid;
    private GameEngine gameEngine;

    // Etats
    private IEtatGlobal etatCourant;
    private IEtatGlobal etatEnableButton;
    private IEtatGlobal etatDisableButton;

    // Observers of Button
    private List<IObserverOfGlobal> observers = new ArrayList<IObserverOfGlobal>();

    public PresentationGlobal() {
        modelGlobal = new ModelGlobal();

        etatEnableButton = new EtatEnableGlobal(this, modelGlobal);
        etatDisableButton = new EtatDisableGlobal(this, modelGlobal);
        etatCourant = etatEnableButton;
    }

    public ModelGlobal getModel() {
        return modelGlobal;
    }

    public PresentationGrid getPresGrid() {
        return presGrid;
    }

    // Point to IVueButton
    public void setView(final IViewGlobal v){
        viewGlobal = v;
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    // Methods for Observer Pattern
    public void  attach(IObserverOfGlobal observer){
        observers.add(observer);
    }

    public  void notifAllObservers() {
        for (IObserverOfGlobal observer : observers){
            observer.updateFromGlobal();
        }
    }

    @Override
    public void updateFromGrid() {
        if(presGrid.getEtatCourant().equals(presGrid.getEtatSwitchPlayer())){
            gameEngine.choose(presGrid.getModelGrid().getRecentSquare()-1);
            if (gameEngine.isEnded()) {
                viewGlobal.notifEndGame();
                try {
                    etatCourant.endgame();
                    viewGlobal.notifEndGame();
                } catch (GlobalException e) {
                }
            }
        this.notifAllObservers();
        }
    }

    @Override
    public void subscribeToGrid(PresentationGrid subject) {
        presGrid = subject;
        presGrid.attach(this);
    }

    //----------Gestion Automate + Facade
    public void setEtatCourant(final IEtatGlobal e) {
        etatCourant = e;
    }

    public IEtatGlobal getEtatCourant() {
        return etatCourant;
    }

    public IEtatGlobal getEtatEnableButton(){
        return etatEnableButton;
    }

    public IEtatGlobal getEtatDisableButton() {
        return etatDisableButton;
    }

    //Its own methods
    public void pressButton(){
        viewGlobal.notifSwitchPlayer();
        this.notifAllObservers();
        try {
            etatCourant.newgame();
        } catch (GlobalException e){
        }
    }
}
