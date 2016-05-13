package com.example.florian.android_bouncingball;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Florian on 14/05/2016.
 */
public class GameView extends SurfaceView implements Runnable{
    Thread t = null;
    SurfaceHolder holder;
    boolean status = false;

    public GameView(Context context) {
        super(context);

        holder = getHolder();
    }

    public void run(){
        if (status){
            //draw
        }
    }

    public void pause(){
        status = false;
        while(true){
            try{
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
        t = null;
    }

    public void resume(){
        status = true;
        t = new Thread(this);
        t.start();
    }
}
