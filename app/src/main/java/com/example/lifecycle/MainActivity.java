package com.example.lifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b_clicker;
    TextView tv_counter;

    int clicks = 0;


    //saves the values of clicks temporarily
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("clickerValue", clicks);
    }

    //gets the temp value of clicks and restores it
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        clicks = savedInstanceState.getInt("clickerValue");
        tv_counter = findViewById(R.id.tv_counter);
        tv_counter.setText(Integer.toString(clicks));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycleApp", "This app is started. ");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycleApp", "This app is stopped. ");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycleApp", "This app is paused. ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycleApp", "This app is resumed. ");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycleApp", "This app is destroyed. ");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycleApp", "This app is restarted. ");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LifeCycleApp", "This app is created. ");

        setContentView(R.layout.activity_main);

        b_clicker = findViewById(R.id.b_clicker);
        tv_counter = findViewById(R.id.tv_counter);

        b_clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                tv_counter.setText(Integer.toString(clicks));
            }
        });
    }
}
