package com.example.timereggapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekBar;
    TextView timerTextView;
    Button goButton;
    boolean isTimerActive = false;
    CountDownTimer countDownTimer;

    public void startAndStopTimer(View view){


        Log.i("Info", "Button is Clicked.");

        if(isTimerActive){
            resetTimer();

        }else {
            timerSeekBar.setEnabled(false);
            goButton.setText("STOP");
            isTimerActive = true;
            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) (millisUntilFinished / 1000));
                }

                @Override
                public void onFinish() {
                    resetTimer();
                    Toast.makeText(MainActivity.this, "Time is finnished.", Toast.LENGTH_LONG).show();
                }
            }.start();
        }
    }

    public void resetTimer(){
        timerSeekBar.setEnabled(true);
        timerSeekBar.setProgress(30);
        countDownTimer.cancel();
        timerTextView.setText("0:30");
        goButton.setText("GO!");
        isTimerActive = false;
    }

    public void updateTimer(int progress){
        int minute = progress / 60;
        int second = progress % 60;
        String secondString = Integer.toString(second);

        if(second <= 9){
            secondString = "0" + secondString;
        }
        timerTextView.setText(minute + ":" + secondString);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = findViewById(R.id.TimerSeekBar);
        timerTextView = findViewById(R.id.TimerTextView);
        goButton = findViewById(R.id.GoButton);

        int max = 600;
        int startingPosition = 30;

        timerSeekBar.setMax(max);
        timerSeekBar.setProgress(startingPosition);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
