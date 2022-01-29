package com.example.quizapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.Question.SMCQ4;
import com.example.quizapp.backend.data.QuestionData;
import com.example.quizapp.ui.addquestion.NVAAddQuestionFragment;
import com.example.quizapp.ui.addquestion.SMCQ4AddQuestionFragment;

import org.w3c.dom.Text;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuizDashboard extends AppCompatActivity {


    List<Question> questionList;
    int index = 0;
    int correctCount = 0;
    int wrongCount = 0;
    ProgressBar progressBar;
    CountDownTimer countDownTimer;
    int timervalue = 60;
    SMCQ4 current;
    Button btn_prev, btn_middle, btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dashboard);
        btn_prev = findViewById(R.id.btn_prev);
        btn_middle = findViewById(R.id.btn_middle);
        btn_next = findViewById(R.id.btn_next);

        progressBar = findViewById(R.id.progress_bar_id);
        progressBar.setProgress(7);

        questionList = (List<Question>) (getIntent().getSerializableExtra("list"));
        callNext(questionList.get(index++));

        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timervalue--;

                progressBar.setProgress(timervalue);


            }

            @Override
            public void onFinish() {

                if(index<questionList.size()) {
                    callNext(questionList.get(index++));
//                    timervalue = 59;
//                    progressBar.setProgress(timervalue);
//                    countDownTimer.start();
                }
                else{
//                Dialog dialog=new Dialog(getApplicationContext());
//                dialog.setContentView(R.layout.custom_timeout_dialog);
//                TextView textView=dialog.findViewById(R.id.timeout_dialog_text);
//                textView.setText(correctCount+" - "+wrongCount);
//                dialog.findViewById(R.id.timeout_dialog_btn).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        finish();
//                    }
//                });
//                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
//                dialog.show();

                }
            }
        }.start();


    }


/*

    void actionOnCorrect(){
        correctCount++;
        index++;
        current=(SMCQ4) questionList.get(index);
//        setText(current);

    }

    void actionOnWrong(){
        wrongCount++;
        index++;
        current=(SMCQ4) questionList.get(index);
//        setText(c/urrent);

    }



*/

    void callNext(Question qs) {
        switch (qs.getType()) {
            case "SMCQ4":
                SMCQ4userFragment fragment1 = new SMCQ4userFragment(qs);
                FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();

                transaction4.add(R.id.fragement_question, fragment1);
                transaction4.commit();

                break;
            case "IVA":
                break;
            case "SWA":
                break;
            case "NVA":
                break;
            default:
                break;


        }
    }

}