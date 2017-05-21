package com.pitfall.lucas.pitfall;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by LUCAS on 20/05/2017.
 */

class Player{
    private static Player instance;
    private Paint brown;
    private float x, y, width, height, speedY;

    private Player()
    {
        brown = new Paint();
        brown.setARGB(255,88,71,1);

        width = PitfallView.screenW * 0.2f;
        height = PitfallView.screenH * 0.03f;
        x = (PitfallView.screenW / 2) - (width / 2);
        y = PitfallView.screenH * 0.8f;

        speedY = 7f;
    }

    public static Player getInstance()
    {
        if(instance == null) instance = new Player();
        return instance;
    }

    public void draw(Canvas canvas)
    {
        canvas.drawRect(0, 0, 100, 120, brown);
    }

    public float GetX() { return x; }
    public float GetY() { return y; }
    public float GetW() { return width; }
    public float GetH() { return height; }
}
