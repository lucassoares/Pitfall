package com.pitfall.lucas.pitfall;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static android.R.color.white;

/**
 * Created by LUCAS on 20/05/2017.
 */

public class PitfallView extends View implements Runnable{
    public static int screenW, screenH;
    public static boolean isDead, isPaused, isUpdating;

    private Handler handler;
    private Context c;

    private Player player;
    private World world;



    public PitfallView(Context context)
    {
        super(context);
        Start(context);
    }

    public PitfallView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
    }

    private void Start(Context context){
        setBackgroundColor(Color.BLACK);
        c = context;
        screenW = c.getResources().getDisplayMetrics().widthPixels;
        screenH = c.getResources().getDisplayMetrics().heightPixels;
        isDead = isPaused = false;
        isUpdating = true;

        player = Player.getInstance();
        world = new World();

        handler = new Handler();
        handler.post(this);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        world.draw(canvas);
        player.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        player.preUpdate(event);
        return true;
    }

    @Override
    public void run(){
        handler.postDelayed(this, 30);
        player.update();
    }
}
