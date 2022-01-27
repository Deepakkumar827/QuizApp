package com.example.quizapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quizapp.R;

public class QuizManager extends AppCompatActivity {
    Button exit4, ok4;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dashboard);
        exit4=findViewById(R.id.exit4);
        exit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        ok4=findViewById(R.id.ok4);
        ok4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), QuizDashboard.class);
                intent.putExtra("subject", "MAD");
                finish();
                startActivity(intent);
            }
        });

    }
}