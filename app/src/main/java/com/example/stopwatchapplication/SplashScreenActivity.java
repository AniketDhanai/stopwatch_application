package com.example.stopwatchapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {
    

    public static int SPLASH_TIMER=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreenActivity.this,MainActivity.class);
                // after splash screen MainActivity page get run//
                startActivity(intent);
                finish();


            }
        },SPLASH_TIMER);

    }
}