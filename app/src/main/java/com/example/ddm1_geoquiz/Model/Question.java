package com.example.ddm1_geoquiz.Model;

public class Question {

    private int mTextResId;
    private boolean answer;

    public Question(int mTextResId, boolean answer) {
        this.mTextResId = mTextResId;
        this.answer = answer;
    }


    public int getQuestion() {
        return mTextResId;
    }

    public void setQuestion(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
