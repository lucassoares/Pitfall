package com.pitfall.lucas.pitfall;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by LUCAS on 20/05/2017.
 */

class Player{
    private static Player instance;
    private Paint brown;
    private float x, y, width, height, speedY;
    private boolean isMoving;

    private Player()
    {
        brown = new Paint();
        brown.setARGB(255,88,71,1);

        width = PitfallView.screenW * 0.2f;
        height = PitfallView.screenH * 0.03f;
        x = (PitfallView.screenW / 2) - (width / 2);
        y = PitfallView.screenH * 0.8f;

        speedY = 7f;
        isMoving = false;
    }

    public static Player getInstance()
    {
        if(instance == null) instance = new Player();
        return instance;
    }

    public void draw(Canvas canvas)
    {
        canvas.drawRect(x, y, x + width, y + height, brown);
        //canvas.drawRect(5, 800, 100, y + height, brown);
    }

    public void preUpdate(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_UP ){
            Log.d("EVENTO",String.valueOf(y));
            isMoving = true;
        }
    }

    public void update(){
        if(isMoving){
            y -= speedY;
        }
    }

    public float GetX() { return x; }
    public float GetY() { return y; }
    public float GetW() { return width; }
    public float GetH() { return height; }
}
