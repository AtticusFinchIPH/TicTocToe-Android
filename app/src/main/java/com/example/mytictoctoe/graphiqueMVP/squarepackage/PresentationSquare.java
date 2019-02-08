package com.example.mytictoctoe.graphiqueMVP.squarepackage;

import com.example.mytictoctoe.graphiqueMVP.gridpackage.PresentationGrid;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfGrid;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfSquare;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.automate.IEtatSquare;
import com.example.mytictoctoe.noyaufonction.Square;

import java.util.ArrayList;
import java.util.List;

public class PresentationSquare implements IObserverOfGrid {

    private IViewSquare viewSquare;
    private Square square;

    // Etats
    private IEtatSquare etatCourant;
    private IEtatSquare etatDisableSquare;
    private IEtatSquare etatEmptySquare;
    private IEtatSquare etatFilledSquare;

    // Observers of Square
    List<IObserverOfSquare> observers = new ArrayList<IObserverOfSquare>();

    public PresentationSquare(){

        //etatDisableSquare
        //etatEmptySquare
        //etatFilledSquare
        etatCourant = etatDisableSquare;
    }

    // Point to Square
    public void setSquare(Square square) {
        this.square = square;
    }

    public Square getSquare() {
        return square;
    }

    // Point to IViewSquare
    public void setViewSquare(IViewSquare viewSquare) {
        this.viewSquare = viewSquare;
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

    }

    @Override
    public void subscribeToGrid() {

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
}
