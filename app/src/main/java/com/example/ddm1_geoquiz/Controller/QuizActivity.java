package com.example.ddm1_geoquiz.Controller;

import android.os.Bundle;

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

    private HashMap<String,Boolean> questions = new HashMap<>();
    private int first_time = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);

        tvQuestion = findViewById(R.id.tv_question);


        if (first_time == 1){
            questions.put("Barcelona is the capital of Spain",false);
            questions.put("Madrid is the capital of Spain",true);
            questions.put("Casablanca is the capital of Morrocco",false);
            questions.put("Rabat is the capital of Morocco",true);
            questions.put("Nantes is the capital of France",false);
            questions.put("Paris is the capital of France",true);

            String randomQuestion = setNextQuestion();
            tvQuestion.setText(randomQuestion);
            first_time++;
        }





        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (questions.get(tvQuestion.getText())){
                    Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizActivity.this,R.string.wrong_toast,Toast.LENGTH_SHORT).show();
                }

                String randomQuestion = setNextQuestion();
                tvQuestion.setText(randomQuestion);

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!questions.get(tvQuestion.getText())){
                    Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizActivity.this,R.string.wrong_toast,Toast.LENGTH_SHORT).show();
                }

                String randomQuestion = setNextQuestion();
                tvQuestion.setText(randomQuestion);
            }
        });

    }

    public String setNextQuestion(){
        List<String> keys = new ArrayList<>(questions.keySet());
        Random r = new Random();
        String randomQuestion = keys.get(r.nextInt(keys.size()));

        return randomQuestion;



    }



}