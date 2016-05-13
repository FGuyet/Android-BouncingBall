package com.example.florian.android_bouncingball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Florian on 14/05/2016.
 */
public class GameView extends SurfaceView implements Runnable{
    Thread t = null;
    SurfaceHolder holder;
    boolean status = false;

    Bitmap ball;
    float x_ball, y_ball;

    public GameView(Context context) {
        super(context);

        holder = getHolder();

        ball = BitmapFactory.decodeResource(getResources(), R.drawable.blueball);
        ball = Bitmap.createScaledBitmap(ball, 50, 50, false);

        x_ball = y_ball = 0;
    }

    public void run(){

        int blueIndex = 0;
        while (status){
            if (!holder.getSurface().isValid()){
                continue;
            }
            blueIndex = (blueIndex + 1)% 256;

            //lock Before painting
            Canvas c = holder.lockCanvas();
            c.drawARGB(255, 100, 30, blueIndex);
            c.drawBitmap(ball, x_ball, y_ball, null);
//          c.drawBitmap(ball, x_ball - ball.getWidth()/2, y_ball - ball.getHeight()/2, null);
            holder.unlockCanvasAndPost(c);
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
