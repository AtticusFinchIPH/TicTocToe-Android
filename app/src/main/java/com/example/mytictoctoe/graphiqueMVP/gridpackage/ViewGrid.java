package com.example.mytictoctoe.graphiqueMVP.gridpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.GridLayout;

import com.example.mytictoctoe.MainActivity;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.PresentationSquare;
import com.example.mytictoctoe.noyaufonction.GameEngine;

public class ViewGrid extends GridLayout implements IViewGrid {

    private PresentationGrid presGrid;

    private MainActivity activity; /// TODO : Attention!!!!!!!!!!!!!

    public ViewGrid (Context context){
        super(context);
    }

    public ViewGrid (Context context, final PresentationGrid pres) {
        super(context);
        presGrid = pres;
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        // TODO : measure
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public void notifEndGame() {

    }
}
