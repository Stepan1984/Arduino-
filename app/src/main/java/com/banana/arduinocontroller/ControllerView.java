package com.banana.arduinocontroller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ControllerView extends View {
    float x = -1;
    float y = -1;
    float cx;
    float cy;
    public ControllerView(Context context) {
        super(context);
    }

    public ControllerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ControllerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ControllerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        cx = canvas.getWidth()/2;
        cy = canvas.getHeight()/2;
        if (x==-1 | y==-1){
            x=cx; y=cy; }
        canvas.drawCircle(x, y, 20, paint);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(cx, cy, 30, paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            x = event.getX();
            y = event.getY();
            invalidate();
            return true;
        }else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            x = event.getX();
            y = event.getY();
            invalidate();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            x = cx;
            y = cy;
            invalidate();

            return true;
        } else return super.onTouchEvent(event);

    }

}
