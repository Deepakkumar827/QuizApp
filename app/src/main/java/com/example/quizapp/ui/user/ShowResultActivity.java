package com.example.quizapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapp.R;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class ShowResultActivity extends AppCompatActivity {

    Button exit;
    CircularProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        exit=findViewById(R.id.exit);
        Intent intent =getIntent();
        ((TextView)findViewById(R.id.total_txt)).setText(intent.getStringExtra("total"));
        ((TextView)findViewById(R.id.solved_txt)).setText(intent.getStringExtra("solved"));
        ((TextView)findViewById(R.id.unsolved_txt)).setText(intent.getStringExtra("unsolved"));
        ((TextView)findViewById(R.id.correct_txt)).setText(intent.getStringExtra("correct"));
        ((TextView)findViewById(R.id.wrong_txt)).setText(intent.getStringExtra("wrong"));

        progressBar=findViewById(R.id.circularProgressBar);
        progressBar.setProgressMax(Integer.parseInt(intent.getStringExtra("total")));
        progressBar.setProgress(Integer.parseInt(intent.getStringExtra("correct")));

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}