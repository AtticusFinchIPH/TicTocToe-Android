package com.example.mytictoctoe.graphiqueMVP.squarepackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.mytictoctoe.R;

public class ViewSquare extends ConstraintLayout implements IViewSquare {

    private PresentationSquare presSquare;

    private View racine;

    private static final int LINE_THICK = 5;
    private static final int ELT_MARGIN = 5;
    private static final int SQ_STROKE_WIDTH = 15;
    private int width, height;
    private Paint squarePaint, oPaint, xPaint;

    public ViewSquare(Context context){
        super(context);

        initPaintSquare(context);
    }

    public ViewSquare (Context context, @Nullable AttributeSet attributeSet){
        super(context, attributeSet);

        initPaintSquare(context);
    }

    public ViewSquare(Context context, @Nullable AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);

        initPaintSquare(context);
    }

    public void setPresSquare(PresentationSquare presSquare) {
        this.presSquare = presSquare;
    }

    // Methods from View
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        height = View.MeasureSpec.getSize(heightMeasureSpec);
        width = View.MeasureSpec.getSize(widthMeasureSpec);

        int size = Math.min(width, height);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawSquare(canvas);
        drawChoosen(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(presSquare.getEtatCourant().equals(presSquare.getEtatEmptySquare())){
            invalidate();
            presSquare.touched();
        }
        return super.onTouchEvent(event);
    }

    // Methods for notifying presSquare
    @Override
    public void notifDisable(boolean b) {

    }

    @Override
    public void notifCharacter(char c) {

    }

    // Methods belong to this class
    private void initPaintSquare(Context context){
        racine = inflate(context, R.layout.view_square, this);

        squarePaint = new Paint();
        squarePaint.setColor(Color.GRAY);
        oPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        oPaint.setColor(Color.RED);
        oPaint.setStyle(Paint.Style.STROKE);
        oPaint.setStrokeWidth(SQ_STROKE_WIDTH);
        xPaint = new Paint(oPaint);
        xPaint.setColor(Color.BLUE);
    }

    private void drawSquare(Canvas canvas) {
        float left = width;
        float right = left + LINE_THICK;
        float top = 0;
        float bottom = height;

        canvas.drawRect(left, top, right, bottom, squarePaint);
    }

    // TODO : Verify
    private void drawChoosen(Canvas canvas) {
        char c = presSquare.getModelSquare().getCharacter();
        if (c == 'O') {
            float cx = width / 2;
            float cy = height / 2;

            canvas.drawCircle(cx, cy, Math.min(width, height) / 2 - ELT_MARGIN * 2, oPaint);

        } else if (c == 'X') {
            float startX = ELT_MARGIN;
            float startY = ELT_MARGIN;
            float endX = startX + width - ELT_MARGIN * 2;
            float endY = startY + height - ELT_MARGIN;

            canvas.drawLine(startX, startY, endX, endY, xPaint);

            float startX2 = width - ELT_MARGIN;
            float startY2 = height - ELT_MARGIN;
            float endX2 = startX2 - width + ELT_MARGIN * 2;
            float endY2 = startY2 + height - ELT_MARGIN;

            canvas.drawLine(startX2, startY2, endX2, endY2, xPaint);
        }
    }
}
