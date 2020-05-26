package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout gameLayout;

    Button goButton;
    Button playAgainButton;

    TextView timerTextView;
    TextView sumTextView;
    TextView scoreTextView;
    TextView resultTextView;

    Button answerButton0;
    Button answerButton1;
    Button answerButton2;
    Button answerButton3;

    ArrayList<Integer> answer = new ArrayList<>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;

    public void start(View view){
        goButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playAgain(timerTextView);
    }

    @SuppressLint("SetTextI18n")
    public void chooseAnswer(View view){
         if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){
             resultTextView.setText("Correct!");
             score++;
         }else {
             resultTextView.setText("Wrong!!");
         }
         numberOfQuestions++;
         scoreTextView.setText(score + "/"+ numberOfQuestions);
         newQuestion();
    }

    @SuppressLint("SetTextI18n")
    public void newQuestion(){
        Random randomNumber = new Random();
        int maxNumber = 20;

        int a = randomNumber.nextInt(maxNumber) + 1;
        int b = randomNumber.nextInt(maxNumber) + 1;
        sumTextView.setText(a + " + " + b);

        locationOfCorrectAnswer = randomNumber.nextInt(4);
        answer.clear();
        for (int i = 0; i<4; i++){
            if(i == locationOfCorrectAnswer){
                answer.add(a + b);
            }else {
                int wrongAnswer = randomNumber.nextInt(40) + 1;
                while (wrongAnswer == a+b){
                    wrongAnswer = randomNumber.nextInt(40) + 1;
                }
                answer.add(wrongAnswer);
            }
        }

        answerButton0.setText(Integer.toString(answer.get(0)));
        answerButton1.setText(Integer.toString(answer.get(1)));
        answerButton2.setText(Integer.toString(answer.get(2)));
        answerButton3.setText(Integer.toString(answer.get(3)));
    }

    @SuppressLint("SetTextI18n")
    public void playAgain(View view){
        answerButton0.setEnabled(true);
        answerButton1.setEnabled(true);
        answerButton2.setEnabled(true);
        answerButton3.setEnabled(true);

        playAgainButton.setVisibility(View.INVISIBLE);
        resultTextView.setText("");
        timerTextView.setText("30s");
        numberOfQuestions = 0;
        score = 0;
        scoreTextView.setText(score + "/"+ numberOfQuestions);

        newQuestion();

        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText((millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                answerButton0.setEnabled(false);
                answerButton1.setEnabled(false);
                answerButton2.setEnabled(false);
                answerButton3.setEnabled(false);
                resultTextView.setText("Done!");
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }.start();

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton = findViewById(R.id.GoButton);
        playAgainButton = findViewById(R.id.PlayAgainButton);

        timerTextView = findViewById(R.id.TimerTextView);
        sumTextView = findViewById(R.id.SumTextView);
        scoreTextView = findViewById(R.id.ScoreTextView);
        resultTextView = findViewById(R.id.ResultTextView);

        answerButton0 = findViewById(R.id.AnswerButton0);
        answerButton1 = findViewById(R.id.AnswerButton1);
        answerButton2 = findViewById(R.id.AnswerButton2);
        answerButton3 = findViewById(R.id.AnswerButton3);
        gameLayout = findViewById(R.id.GameLayout);

        goButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);

    }
}
