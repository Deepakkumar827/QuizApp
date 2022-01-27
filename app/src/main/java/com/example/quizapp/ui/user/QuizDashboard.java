package com.example.quizapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.quizapp.R;

public class QuizDashboard extends AppCompatActivity {
    TextView txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dashboard);
        txt2=findViewById(R.id.textView);

        Intent intent=getIntent();
        String message=intent.getExtras().get("subject").toString();
        txt2.setText(message);

    }
}