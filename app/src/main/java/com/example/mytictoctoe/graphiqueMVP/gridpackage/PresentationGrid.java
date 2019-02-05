package com.example.mytictoctoe.graphiqueMVP.gridpackage;

import com.example.mytictoctoe.graphiqueMVP.gridpackage.automate.IEtatGrid;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfButton;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfGrid;
import com.example.mytictoctoe.noyaufonction.GameEngine;

import java.util.ArrayList;
import java.util.List;

public class PresentationGrid implements IObserverOfButton {

    private IViewGrid viewGrid;
    private GameEngine gameEngine;

    // Etats
    private IEtatGrid etatCourant;
    private IEtatGrid etatInGame;
    private IEtatGrid etatEndGame;

    // Observers of Button
    private List<IObserverOfGrid> observers = new ArrayList<IObserverOfGrid>();

    public PresentationGrid (){

        //etatInGame
        //etatEndGame
        etatCourant = etatEndGame;
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    // Point to IViewGrid
    public void setViewGrid(IViewGrid viewGrid) {
        this.viewGrid = viewGrid;
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

    @Override
    public void updateFromButton() {

    }

    @Override
    public void subscribeToButton() {

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

    public IEtatGrid getEtatEndGame() {
        return etatEndGame;
    }
}
