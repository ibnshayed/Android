package com.example.timestablesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTablesListView;

    public void generateTimesTablesListItems(int timesTablesNumber){
        ArrayList<String> timesTablesContents = new ArrayList<>();
        for (int i = 1; i<=10; i++){
            timesTablesContents.add(Integer.toString(timesTablesNumber * i));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timesTablesContents);
        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekBar = findViewById(R.id.timesTablesSeekBar);
        timesTablesListView = findViewById(R.id.timesTablesListView);


        int max = 20;
        int startingPosition = 10;
        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startingPosition);

        generateTimesTablesListItems(startingPosition);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTablesNumber;
                if(progress < min){
                    timesTablesNumber = min;
                }else {
                    timesTablesNumber = progress;
                }
                timesTablesSeekBar.setProgress(timesTablesNumber);
                Log.i("SeekBar Number: " , Integer.toString(timesTablesNumber));
                generateTimesTablesListItems(timesTablesNumber);
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
