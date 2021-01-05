package com.example.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private boolean toggleButton = true;


    public void fade(View view){

        Log.i("Info: ", "Image Clicked.");

        ImageView catOneImageView = (ImageView) findViewById(R.id.catOneImageView);
        ImageView catTwoImageView = (ImageView) findViewById(R.id.catTowImageView);

        if(toggleButton){
            toggleButton = false;
            catOneImageView.animate().alpha(0).setDuration(5000);
            catTwoImageView.animate().alpha(1).setDuration(5000);
        }
        else if(!toggleButton){
            toggleButton = true;
            catOneImageView.animate().alpha(1).setDuration(5000);
            catTwoImageView.animate().alpha(0).setDuration(5000);
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
