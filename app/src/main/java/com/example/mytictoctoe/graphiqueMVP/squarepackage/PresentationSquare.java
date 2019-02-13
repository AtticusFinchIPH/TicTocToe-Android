package com.example.mytictoctoe.graphiqueMVP.squarepackage;

import com.example.mytictoctoe.graphiqueMVP.gridpackage.PresentationGrid;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfGrid;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfSquare;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.automate.EtatDisableSquare;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.automate.EtatEmptySquare;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.automate.EtatFilledSquare;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.automate.IEtatSquare;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.automate.SquareException;
import com.example.mytictoctoe.noyaufonction.Square;

import java.util.ArrayList;
import java.util.List;

public class PresentationSquare implements IObserverOfGrid {

    private IViewSquare viewSquare;
    private ModelSquare modelSquare;

    private PresentationGrid presGrid;

    // Etats
    private IEtatSquare etatCourant;
    private IEtatSquare etatDisableSquare;
    private IEtatSquare etatEmptySquare;
    private IEtatSquare etatFilledSquare;

    // Observers of Square
    List<IObserverOfSquare> observers = new ArrayList<IObserverOfSquare>();

    public PresentationSquare(){

        etatDisableSquare = new EtatDisableSquare(this, modelSquare);
        etatEmptySquare = new EtatEmptySquare(this, modelSquare);
        etatFilledSquare = new EtatFilledSquare(this, modelSquare);
        etatCourant = etatDisableSquare;
    }

    // Point to IViewSquare and ModelSquare
    public void setView(IViewSquare viewSquare) {
        this.viewSquare = viewSquare;
    }

    public void setModelSquare(ModelSquare modelSquare) {
        this.modelSquare = modelSquare;
    }

    public ModelSquare getModelSquare() {
        return modelSquare;
    }

    // Methods for Observer Pattern
    public void  attach(IObserverOfSquare observer){
        observers.add(observer);
    }

    public  void notifAllObservers() {
        for (IObserverOfSquare observer : observers){
            observer.updateFromSquare();
        }
    }

    @Override
    public void updateFromGrid() {
        if (presGrid.getEtatCourant().equals(presGrid.getEtatSwitchPlayer())) {
            try{
                etatCourant.choose();
                modelSquare.setCharacter(presGrid.getModelGrid().getCurrentCharacter());
            } catch (SquareException e){
            }
        } else if (presGrid.getEtatCourant().equals(presGrid.getEtatInGame())){
            try {
                etatCourant.newgame();
            } catch (SquareException e){
            }
        } else if(presGrid.getEtatCourant().equals(presGrid.getEtatEndGame())){
            try {
                etatCourant.endgame();
            } catch (SquareException e){
            }
        }
    }

    @Override
    public void subscribeToGrid(PresentationGrid subject) {
        presGrid = subject;
        presGrid.attach(this);
    }

    //----------Gestion Automate + Facade
    public void setEtatCourant(final IEtatSquare e) {
        etatCourant = e;
    }

    public IEtatSquare getEtatCourant() {
        return etatCourant;
    }

    public IEtatSquare getEtatDisableSquare() {
        return etatDisableSquare;
    }

    public IEtatSquare getEtatEmptySquare() {
        return etatEmptySquare;
    }

    public IEtatSquare getEtatFilledSquare() {
        return etatFilledSquare;
    }

    public void touched(){
        try{
            etatCourant.choose();
        } catch (SquareException e){
        }

        notifAllObservers();
    }
}
