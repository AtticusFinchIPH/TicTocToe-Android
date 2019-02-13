package com.example.mytictoctoe.graphiqueMVP.gridpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;

import com.example.mytictoctoe.R;
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
        viewSquare1.findViewById(R.id.square_1);
        viewSquare2.findViewById(R.id.square_2);
        viewSquare3.findViewById(R.id.square_3);
        viewSquare4.findViewById(R.id.square_4);
        viewSquare5.findViewById(R.id.square_5);
        viewSquare6.findViewById(R.id.square_6);
        viewSquare7.findViewById(R.id.square_7);
        viewSquare8.findViewById(R.id.square_8);
        viewSquare9.findViewById(R.id.square_9);

        this.setColumnCount(column);
        this.setRowCount(row);

    }
}
