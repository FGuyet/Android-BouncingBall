package com.example.florian.android_bouncingball;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    GameView v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //FullScreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        v = new GameView(this);

        setContentView(v);
    }

    @Override
    protected void onPause(){
        super.onPause();
        v.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        v.resume();
    }

}
