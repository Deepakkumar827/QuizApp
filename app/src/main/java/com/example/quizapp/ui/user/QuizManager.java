package com.example.quizapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.Question.SMCQ4;
import com.example.quizapp.backend.data.DATA;
import com.example.quizapp.backend.data.QuestionData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizManager extends AppCompatActivity {
    Button exit, ok;
    EditText  no_of_question;
    Spinner test_mode, test_type, subject;
    List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_manager);




        subject=findViewById(R.id.subject);
        no_of_question=findViewById(R.id.no_of_question);
        test_mode=findViewById(R.id.test_mode);
        test_type=findViewById(R.id.test_type);

        exit=findViewById(R.id.exit);
        ok=findViewById(R.id.submit);


        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, DATA.subject);
        subject.setAdapter(adapter1);
        subject.setSelection(adapter1.getPosition("java"));

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, DATA.test_type);
        test_type.setAdapter(adapter2);
        test_type.setSelection(adapter2.getPosition("only_SMCQ4"));
        test_type.setEnabled(false);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, DATA.test_mode);
        test_mode.setAdapter(adapter3);
        test_mode.setSelection(adapter3.getPosition("Single_Mode"));
        test_mode.setEnabled(false);





        Bundle bundle=getIntent().getExtras();
//        if(!bundle.get("subject").toString().trim().matches("")){
//
//            subject.setSelection(adapter1.getPosition(bundle.get("subject").toString()));
//
//        }
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), QuizDashboard.class);
                if (no_of_question.getText().toString().trim().matches("") || Integer.parseInt(no_of_question.getText().toString().trim())==0) {
                    Toast.makeText(getApplicationContext(), "Please fill in all the required fields.", Toast.LENGTH_SHORT).show();
                }
                else {
//                    intent.putExtra("subject", subject.getSelectedItem().toString().trim());
//                    intent.putExtra("test_type", test_type.getSelectedItem().toString().trim());
//                    intent.putExtra("test_mode", test_mode.getSelectedItem().toString().trim());
//                    intent.putExtra("no_of_question", no_of_question.getText().toString());

                    questionList=QuestionData.mAD_SMCQ;

                    Collections.shuffle(questionList);
                    intent.putExtra("list", (Serializable) questionList);

                    startActivity(intent);
                                        finish();

                }
            }
        });

    }
}