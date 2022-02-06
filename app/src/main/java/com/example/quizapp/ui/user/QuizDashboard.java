package com.example.quizapp.ui.user;

import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.Question.MCQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizDashboard extends AppCompatActivity {
/////////////

    ArrayList<String> answer_given;
    List<Question> questionList;
    int index = -1;
    ProgressBar progressBar;
    CountDownTimer countDownTimer;
    int timervalue = 0;
    MCQ current;
    Button btn_prev, btn_middle, btn_next;
    int total_question, question_unsolved, question_solved, question_wrong, question_correct;
    TextView timer, total_question_txt, question_unsolved_txt, question_solved_txt, question_wrong_txt, question_correct_txt;
    int timelimit_min = 600;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dashboard);
        btn_prev = findViewById(R.id.btn_prev);
        btn_middle = findViewById(R.id.btn_middle);
        btn_next = findViewById(R.id.btn_next);
        timer = findViewById(R.id.timer);
        builder = new AlertDialog.Builder(QuizDashboard.this);


        total_question_txt = findViewById(R.id.question_total);
        question_solved_txt = findViewById(R.id.question_total_solved);
        question_unsolved_txt = findViewById(R.id.question_unsolved);
        question_correct_txt = findViewById(R.id.question_correct);
        question_wrong_txt = findViewById(R.id.question_wrong);


        questionList = (List<Question>) (getIntent().getSerializableExtra("list"));
        answer_given = new ArrayList<>(Arrays.asList(new String[questionList.size()]));

        Collections.fill(answer_given, "");
        callNext(questionList, ++index);

        total_question = questionList.size();
        question_unsolved = questionList.size();
        question_solved = 0;
        question_wrong = 0;
        question_correct = 0;
        updateTopBar();


        countDownTimer = new CountDownTimer(timelimit_min * 60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timervalue++;
                timer.setText(timervalue / 3600 + ":" + (timervalue % 3600) / 60 + ":" + ((timervalue % 3600) % 60));
            }

            @Override
            public void onFinish() {

               /* Dialog dialog=new Dialog(getApplicationContext());
                dialog.setContentView(R.layout.custom_timeout_dialog);
                TextView textView=dialog.findViewById(R.id.timeout_dialog_text);
                textView.setText(correctCount+" - "+wrongCount);
                dialog.findViewById(R.id.timeout_dialog_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.show();*/

            }
        }.start();

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNext(questionList, --index);
            }
        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNext(questionList, ++index);
            }
        });
    }


    private void callNext(List<Question> questionList, int i) {
        if (i < 0) {
            Toast.makeText(getApplicationContext(), "you have come to the start of question", Toast.LENGTH_LONG).show();

            return;
        } else if (i >= questionList.size()) {
            index--;
            builder.setMessage("you have come to the end of question")
                    .setCancelable(false)
                    .setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                            Intent intent=new Intent(getApplicationContext(), ShowResultActivity.class);
                            intent.putExtra("total", Integer.toString(total_question));
                            intent.putExtra("solved", Integer.toString(question_solved));
                            intent.putExtra("unsolved", Integer.toString(question_unsolved));
                            intent.putExtra("correct", Integer.toString(question_correct));
                            intent.putExtra("wrong", Integer.toString(question_wrong));

                            startActivity(intent);

                        }
                    }).setNegativeButton("BACK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    /////////nothing to do
                }
            });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Alert");
            alert.getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND, 1);
            alert.show();
            return;
        } else {
            switch (questionList.get(i).getType()) {
                case "MCQ":
                    SMCQ4userFragment fragment1 = new SMCQ4userFragment(questionList.get(i));
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                    transaction.replace(R.id.fragement_question, fragment1);
                    transaction.commit();


                    break;
                case "IVA":
                    break;
                case "SWA":
                    break;
                case "NAT":
                    break;
                default:
                    break;

            }
        }
    }


    void updateTopBar() {
        total_question_txt.setText(total_question + "");
        question_unsolved_txt.setText(question_unsolved + "");
        question_solved_txt.setText(question_solved + "");
        question_wrong_txt.setText(question_wrong + "");
        question_correct_txt.setText(question_correct + "");

    }

}





























































/*

    void actionOnCorrect(){
        correctCount++;
        index++;
        current=(MCQ) questionList.get(index);
//        setText(current);

    }

    void actionOnWrong(){
        wrongCount++;
        index++;
        current=(MCQ) questionList.get(index);
//        setText(c/urrent);

    }



*/