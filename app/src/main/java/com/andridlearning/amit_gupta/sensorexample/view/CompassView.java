package com.andridlearning.amit_gupta.sensorexample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Amit_Gupta on 8/21/15.
 */
public class CompassView extends View {

    private Paint paint;
    private float position = 0;

    public CompassView(Context context) {
        super(context);
        init();
    }

    private void init(){
       paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        paint.setTextSize(25);
        paint.setStyle(Paint.Style.STROKE);
//        paint.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int xPoint = getMeasuredWidth() /2;
        int yPoint = getMeasuredHeight()/2;
        float radius = (float) (Math.max(xPoint, yPoint) * 0.6);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(xPoint, yPoint, radius, paint);
        paint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);

        // 3.143 is a good approximation for the circle
        paint.setColor(Color.RED);
        canvas.drawLine(xPoint,
                yPoint,
                (float) (xPoint + radius
                        * Math.sin((double) (-position) / 180 * 3.143)),
                (float) (yPoint - radius
                        * Math.cos((double) (-position) / 180 * 3.143)), paint);
        paint.setColor(Color.YELLOW);

        canvas.drawText(String.valueOf(position), xPoint, yPoint, paint);

    }

    public void updateData(float position) {
        this.position = position;
        invalidate();
    }
}
