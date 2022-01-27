package com.example.quizapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.quizapp.R;

public class QuizDashboard extends AppCompatActivity {
    String test_mode, test_type, subject;
    int no_of_question;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dashboard);
        Bundle bundle=getIntent().getExtras();
//        test_mode=bundle.get("test_mode").toString();
//        subject=bundle.get("subject").toString();
//        no_of_question=Integer.parseInt(bundle.get("no_of_question").toString().trim());
//        test_type=bundle.get("test_type").toString();


    }

}