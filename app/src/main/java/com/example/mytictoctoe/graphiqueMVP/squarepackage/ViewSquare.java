package com.example.mytictoctoe.graphiqueMVP.squarepackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ViewSquare extends View implements IViewSquare {

    private PresentationSquare presSquare;

    private static final int LINE_THICK = 5;
    private static final int ELT_MARGIN = 5;
    private static final int SQ_STROKE_WIDTH = 15;
    private int width, height;
    private Paint squarePaint, oPaint, xPaint;

    public ViewSquare(Context context){
        super(context);
    }

    public ViewSquare(Context context, final PresentationSquare pres){
        super(context);
        presSquare = pres;

        squarePaint = new Paint();
        oPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        oPaint.setColor(Color.RED);
        oPaint.setStyle(Paint.Style.STROKE);
        oPaint.setStrokeWidth(SQ_STROKE_WIDTH);
        xPaint = new Paint(oPaint);
        xPaint.setColor(Color.BLUE);
    }

    public ViewSquare (Context context, @Nullable AttributeSet attributeSet){
        super(context, attributeSet);

        squarePaint = new Paint();
        squarePaint.setColor(Color.GRAY);
        oPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        oPaint.setColor(Color.RED);
        oPaint.setStyle(Paint.Style.STROKE);
        oPaint.setStrokeWidth(SQ_STROKE_WIDTH);
        xPaint = new Paint(oPaint);
        xPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        height = View.MeasureSpec.getSize(heightMeasureSpec);
        width = View.MeasureSpec.getSize(widthMeasureSpec);

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawSquare(canvas);
        drawChoosen(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

        // TODO : Invalidate()
    }

    @Override
    public void notifDisable(boolean b) {

    }

    @Override
    public void notifCharacter(char c) {

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
        char c = presSquare.getSquare().getCharacter();
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
