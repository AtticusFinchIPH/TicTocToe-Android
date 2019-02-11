package com.example.mytictoctoe.graphiqueMVP.gridpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;

import com.example.mytictoctoe.R;

public class ViewGrid extends GridLayout implements IViewGrid {

    private PresentationGrid presGrid;

    private View racine;

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

        this.setColumnCount(column);
        this.setRowCount(row);

    }
}
