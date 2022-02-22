package com.example.ddm1_geoquiz.Controller;

import android.os.Bundle;

import com.example.ddm1_geoquiz.Model.Question;
import com.example.ddm1_geoquiz.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private TextView tvQuestion;


    private Question[] mQuestions = new Question[]{
            new Question(R.string.question_bcn,false),
            new Question(R.string.question_mad,true),
            new Question(R.string.question_cas,false),
            new Question(R.string.question_rab,true),
            new Question(R.string.question_nan,false),
            new Question(R.string.question_par,true)
    };

    private int first_time = 1;
    private int numQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);

        tvQuestion = findViewById(R.id.tv_question);


        if (first_time == 1){
            Random r = new Random();

            numQuestion = r.nextInt(mQuestions.length - 1);
            setNextQuestion(numQuestion);
            first_time++;
        }


        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mQuestions[numQuestion].isAnswer()){
                    Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizActivity.this,R.string.wrong_toast,Toast.LENGTH_SHORT).show();
                }

                Random r = new Random();
                numQuestion = r.nextInt(mQuestions.length-1);
                setNextQuestion(numQuestion);

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!mQuestions[numQuestion].isAnswer()){
                    Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizActivity.this,R.string.wrong_toast,Toast.LENGTH_SHORT).show();
                }

                Random r = new Random();
                int numQuestion = r.nextInt(mQuestions.length-1);
                setNextQuestion(numQuestion);
            }
        });

    }

    public void setNextQuestion(int nextNumber){


        tvQuestion.setText(mQuestions[nextNumber].getmTextResId());

    }



}