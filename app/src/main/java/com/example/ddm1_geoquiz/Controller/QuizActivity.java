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
            new Question(R.string.question_rab,false),
            new Question(R.string.question_nan,false),
            new Question(R.string.question_par,false)
    };

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
            questions.put("",false);
            questions.put("",true);
            questions.put("",false);
            questions.put("",true);
            questions.put("",false);
            questions.put("",true);

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