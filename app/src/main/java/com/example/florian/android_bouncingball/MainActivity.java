package com.example.florian.android_bouncingball;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    GameView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
