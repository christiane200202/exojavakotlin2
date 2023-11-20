package com.example.thermometre2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Thermometer extends View
{
    private float temp;

    public Thermometer(Context context){
        super(context);
        this.temp=23.0f*10;
    }
    public Thermometer(Context context, float temp){
        super(context);
        this.temp=temp*10;
    }
    public  void setTemp(float temp)
    {
        this.temp=temp*100;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        p.setColor(Color.RED);
        canvas.drawLine((this.getWidth()/2.0f),this.getHeight()-60.0f-temp,(this.getWidth()/2.0f),getHeight()-60.0f,p);
        canvas.drawCircle((this.getWidth()/2.0f),this.getHeight()-60.0F,60.0f,p);
        invalidate();

    }
}
