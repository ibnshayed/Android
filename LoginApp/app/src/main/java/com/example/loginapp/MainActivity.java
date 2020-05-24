package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void login(View view){
        Log.i("Info: " ,"Logged in.");

        EditText userNameEditText = (EditText) findViewById(R.id.userNameEditText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);


        String userName = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        Toast.makeText(this, "Username: " + userName + " Password: " + password, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
