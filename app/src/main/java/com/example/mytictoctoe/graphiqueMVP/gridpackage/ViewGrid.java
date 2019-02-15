package com.example.mytictoctoe.graphiqueMVP.gridpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;

import com.example.mytictoctoe.R;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.PresentationSquare;
import com.example.mytictoctoe.graphiqueMVP.squarepackage.ViewSquare;

public class ViewGrid extends GridLayout implements IViewGrid {

    private PresentationGrid presGrid;

    private View racine;
    private ViewSquare viewSquare1;
    private ViewSquare viewSquare2;
    private ViewSquare viewSquare3;
    private ViewSquare viewSquare4;
    private ViewSquare viewSquare5;
    private ViewSquare viewSquare6;
    private ViewSquare viewSquare7;
    private ViewSquare viewSquare8;
    private ViewSquare viewSquare9;

    private PresentationSquare presSquare1;
    private PresentationSquare presSquare2;
    private PresentationSquare presSquare3;
    private PresentationSquare presSquare4;
    private PresentationSquare presSquare5;
    private PresentationSquare presSquare6;
    private PresentationSquare presSquare7;
    private PresentationSquare presSquare8;
    private PresentationSquare presSquare9;

    private int column = 3;
    private int row = 3;

    public ViewGrid (Context context){
        super(context);

        initGrid(context);
    }

    public ViewGrid (Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);

        initGrid(context);
    }

    public ViewGrid (Context context, @Nullable AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);

        initGrid(context);
    }

    public void setPresGrid(PresentationGrid presGrid) {
        this.presGrid = presGrid;
    }

    // Methods from View
    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        // TODO : measure
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    // Methods for notifying presGrid
    @Override
    public void notifEndGame() {

    }

    // Methods belong to this class
    public void initGrid(Context context) {
        racine = inflate(context, R.layout.view_grid, this);
        viewSquare1 = racine.findViewById(R.id.square_1);
        presSquare1 = new PresentationSquare();
        viewSquare1.setPresSquare(presSquare1);
        presSquare1.setView(viewSquare1);

        viewSquare2 = racine.findViewById(R.id.square_2);
        presSquare2 = new PresentationSquare();
        viewSquare2.setPresSquare(presSquare2);;
        presSquare2.setView(viewSquare2);

        viewSquare3 = racine.findViewById(R.id.square_3);
        presSquare3 = new PresentationSquare();
        viewSquare3.setPresSquare(presSquare3);
        presSquare3.setView(viewSquare3);

        viewSquare4 = racine.findViewById(R.id.square_4);
        presSquare4 = new PresentationSquare();
        viewSquare4.setPresSquare(presSquare4);
        presSquare4.setView(viewSquare4);

        viewSquare5 = racine.findViewById(R.id.square_5);
        presSquare5 = new PresentationSquare();
        viewSquare5.setPresSquare(presSquare5);
        presSquare5.setView(viewSquare5);

        viewSquare6 = racine.findViewById(R.id.square_6);
        presSquare6 = new PresentationSquare();
        viewSquare6.setPresSquare(presSquare6);
        presSquare6.setView(viewSquare6);

        viewSquare7 = racine.findViewById(R.id.square_7);
        viewSquare7.setPresSquare(presSquare7);
        presSquare7 = new PresentationSquare();
        presSquare7.setView(viewSquare7);

        viewSquare8 = racine.findViewById(R.id.square_8);
        presSquare8 = new PresentationSquare();
        viewSquare8.setPresSquare(presSquare8);
        presSquare8.setView(viewSquare8);

        viewSquare9 = racine.findViewById(R.id.square_9);
        presSquare9 = new PresentationSquare();
        viewSquare9.setPresSquare(presSquare9);
        presSquare9.setView(viewSquare9);

        this.setColumnCount(column);
        this.setRowCount(row);

    }
}
