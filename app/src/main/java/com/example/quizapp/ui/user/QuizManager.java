package com.example.quizapp.ui.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.Question.SMCQ4;
import com.example.quizapp.backend.data.DATA;
import com.example.quizapp.backend.data.QuestionData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class QuizManager extends AppCompatActivity {
    Button exit, ok;
    EditText no_of_question;
    Spinner test_mode, test_type, subject;
    List<Question> questionList;
    public  ArrayList<Question> array=new ArrayList<>();
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_manager);


        subject = findViewById(R.id.subject);
        no_of_question = findViewById(R.id.no_of_question);
        test_mode = findViewById(R.id.test_mode);
        test_type = findViewById(R.id.test_type);

        no_of_question.setText("77");

        exit = findViewById(R.id.exit);
        ok = findViewById(R.id.submit);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, DATA.subject);
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


        Bundle bundle = getIntent().getExtras();
//        if(!bundle.get("subject").toString().trim().matches("")){
//            subject.setSelection(adapter1.getPosition(bundle.get("subject").toString()));
//
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
                Intent intent = new Intent(getApplicationContext(), QuizDashboard.class);
                if (no_of_question.getText().toString().trim().matches("") || Integer.parseInt(no_of_question.getText().toString().trim()) == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill in all the required fields.", Toast.LENGTH_SHORT).show();
                } else {
                    String subject_txt= subject.getSelectedItem().toString().trim();
                    String test_type_txt= test_type.getSelectedItem().toString().trim();
                    String no_of_question_txt= no_of_question.getText().toString();

                    String folder="test";


//                    questionList=question_ar/ray_list;
//                    array.add(Question.createSMCQ4("Deepak","MAD", "Android is -", "an operating system", "a web browser", "a web server", "None of the above", 1, "none"));

//                    QuestionData.setmAD_SMCQ();
                    questionList=QuestionData.mAD_SMCQ;



//                    databaseReference= FirebaseDatabase.getInstance().getReference().child("MAD-SMCQ4");
////                    databaseReference= FirebaseDatabase.getInstance().getReference(folder);
//                    databaseReference.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                              for(DataSnapshot dataSnapshot: snapshot.getChildren()){
////                                  questionList.add((Question) dataSnapshot.getValue(Question.class));
//                                  array.add( dataSnapshot.getValue(Question.class));
////                                  Log.d("-----", (dataSnapshot.getValue(Question.class).getClass().toString()));
//                            }
//
//                              questionList=array;
//                            Collections.shuffle(questionList);
//                            intent.putExtra("list", (Serializable) questionList);
//                            finish();
//////
//                            startActivity(intent);
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });


                    Collections.shuffle(questionList);
                    intent.putExtra("list", (Serializable) questionList);
                    finish();
////
                    startActivity(intent);



                }
            }
        });

    }
}