package com.example.stopwatchapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private  int seconds=0;
    private  int milliseconds=0;
    private boolean running;

    ImageView start,pause,reset;
    TextView timerview,msectext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTimer();

        start = findViewById(R.id.play_btn);
        pause = findViewById(R.id.pause_btn);
        reset = findViewById(R.id.reset_btn);
        timerview = findViewById(R.id.time_view);
        msectext=findViewById(R.id.msec);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = true;

            }
        });


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = false;
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = false;
                seconds = 0;
                milliseconds=0;
            }
        });


    }
    private void startTimer () {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hrs = seconds / 3600;
                int mins = (seconds % 3600) / 60;
                int sec = seconds % 60;
                String time = String.format("%02d:%02d:%02d", hrs, mins, sec);
                timerview.setText(time);

                String msecTime = String.format("%02d", milliseconds);
                msectext.setText(msecTime);

                if (running) {
                    milliseconds++;
                    if (milliseconds >= 60) {
                        seconds++;
                        milliseconds = 0;
                    }
                }

                handler.postDelayed(this, 1);
            }
        });
    }

}