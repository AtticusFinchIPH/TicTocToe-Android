package com.example.mytictoctoe.graphiqueMVP.globalpackage;

import com.example.mytictoctoe.graphiqueMVP.globalpackage.automate.IEtatGlobal;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfGlobal;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfGrid;

import java.util.ArrayList;
import java.util.List;

public class PresentationGlobal implements IObserverOfGrid {

    private IViewGlobal viewGlobal;
    private ModelGlobal modelGlobal;

    // Etats
    private IEtatGlobal etatCourant;
    private IEtatGlobal etatActiveButton;
    private IEtatGlobal etatDisableButton;

    // Observers of Button
    private List<IObserverOfGlobal> observers = new ArrayList<IObserverOfGlobal>();

    public PresentationGlobal() {
        modelGlobal = new ModelGlobal();

        //etatActiveButton
        //etatDisableButton
        etatCourant = etatActiveButton;
    }

    // Point to IVueButton
    public void setView(final IViewGlobal v){
        viewGlobal = v;
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

    }

    @Override
    public void subscribeToGrid() {

    }

    //----------Gestion Automate + Facade
    public void setEtatCourant(final IEtatGlobal e) {
        etatCourant = e;
    }

    public IEtatGlobal getEtatCourant() {
        return etatCourant;
    }

    public IEtatGlobal getEtatActiveButton(){
        return etatActiveButton;
    }

    public IEtatGlobal getEtatDisableButton() {
        return etatDisableButton;
    }
}
