package com.example.mytictoctoe.graphiqueMVP.buttonpackage;

import com.example.mytictoctoe.graphiqueMVP.buttonpackage.automate.IEtatButton;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfButton;
import com.example.mytictoctoe.graphiqueMVP.iobservers.IObserverOfGrid;

import java.util.ArrayList;
import java.util.List;

public class PresentationButton implements IObserverOfGrid {

    private IViewButton viewButton;
    private ModelButton modelButton;

    // Etats
    private IEtatButton etatCourant;
    private IEtatButton etatActiveButton;
    private IEtatButton etatDisableButton;

    // Observers of Button
    private List<IObserverOfButton> observers = new ArrayList<IObserverOfButton>();

    public PresentationButton() {
        modelButton = new ModelButton();

        //etatActiveButton
        //etatDisableButton
        etatCourant = etatActiveButton;
    }

    // Point to IVueButton
    public void setView(final  IViewButton v){
        viewButton = v;
    }

    // Methods for Observer Pattern
    public void  attach(IObserverOfButton observer){
        observers.add(observer);
    }

    public  void notifAllObservers() {
        for (IObserverOfButton observer : observers){
            observer.updateFromButton();
        }
    }

    @Override
    public void updateFromGrid() {

    }

    @Override
    public void subscribeToGrid() {

    }

    //----------Gestion Automate + Facade
    public void setEtatCourant(final IEtatButton e) {
        etatCourant = e;
    }

    public IEtatButton getEtatCourant() {
        return etatCourant;
    }

    public IEtatButton getEtatActiveButton(){
        return etatActiveButton;
    }

    public IEtatButton getEtatDisableButton() {
        return etatDisableButton;
    }
}
