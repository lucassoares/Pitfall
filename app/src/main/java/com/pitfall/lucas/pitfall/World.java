package com.pitfall.lucas.pitfall;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by LUCAS on 20/05/2017.
 */

public class World{
    private Paint green, darkGreen;

    public void draw(Canvas canvas)
    {
        Rect sky = new Rect();
        Rect floor = new Rect();
        darkGreen = new Paint();
        green = new Paint();
        green.setARGB(255,0,198,16);
        darkGreen.setARGB(255,1,88,8);
        floor.set(0,canvas.getHeight() - 200,canvas.getWidth(),canvas.getHeight());
        sky.set(0,0, canvas.getWidth(), canvas.getHeight() - 200);
        canvas.drawRect(sky,darkGreen);
        canvas.drawRect(floor,green);
    }
}
