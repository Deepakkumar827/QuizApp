package com.example.quizapp.ui.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowId;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.IVA;
import com.example.quizapp.backend.Question.MCQ;
import com.example.quizapp.backend.Question.NAT;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.Question.SWA;
import com.example.quizapp.backend.data.DATA;
import com.example.quizapp.backend.data.Dir;
import com.example.quizapp.backend.data.QuestionData;
import com.example.quizapp.backend.data.Trie;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizManager extends AppCompatActivity {
    Button exit, ok;
    ProgressBar waitProgressbar;
    Timer progressbarTimer;
    int  progressbarCount=0;
    EditText no_of_question;
    Spinner    standard, test_type, subject, chapter;
    List<Question> questionList;
//    public ArrayList<Question> array = new ArrayList<>();
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_manager);


        standard = findViewById(R.id.standard);
        subject = findViewById(R.id.subject);
        no_of_question = findViewById(R.id.no_of_question);
        test_type = findViewById(R.id.test_type);
        chapter = findViewById(R.id.chapter);

        no_of_question.setText("111111");
        no_of_question.setEnabled(false);

        exit = findViewById(R.id.exit);
        ok = findViewById(R.id.submit);
        waitProgressbar=findViewById(R.id.quiz_manager_progressbar);




        ArrayList<String> list_std=new ArrayList<>();
        for(Trie std: Dir.getInstanceOfDir().child.get(0).child ){
            list_std.add(std.name);
        }
        for(String s:list_std){
            Log.w("asdf--", s );

        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,list_std );
        standard.setAdapter(adapter1);


        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, DATA.test_type);
        test_type.setAdapter(adapter3);
        test_type.setSelection(adapter3.getPosition("SWA"));
//        test_type.setEnabled(false);

        standard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                setSubject();
                /*
                int std_selected_index=standard.getSelectedItemPosition();
                ArrayList<String> list_sub=new ArrayList<>();
                for(Trie std: Dir.getInstanceOfDir().child.get(0).child.get(std_selected_index).child ){
                    list_sub.add(std.name);
                }
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, list_sub);
                subject.setAdapter(adapter2);
*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                setChapter();
                /*int std_selected_index=standard.getSelectedItemPosition();

                int sub_selected_index=subject.getSelectedItemPosition();
                ArrayList<String> list_chapter=new ArrayList<>();
                for(Trie cht: Dir.getInstanceOfDir().child.get(0).child.get(std_selected_index).child.get(sub_selected_index).child ){
                    list_chapter.add(cht.name);
                }
                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, list_chapter);
                subject.setAdapter(adapter3);
//                subject.setSelection(adapter2.getPosition("MAD"));
*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




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

        questionList = new ArrayList<>();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                waitProgressbar.setVisibility(View.VISIBLE);

                questionList.clear();

                progressbar();
                Intent intent = new Intent(getApplicationContext(), QuizDashboard.class);
                if (no_of_question.getText().toString().trim().matches("") || Integer.parseInt(no_of_question.getText().toString().trim()) == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill in all the required fields.", Toast.LENGTH_SHORT).show();
                } else {
                    String subject_txt = subject.getSelectedItem().toString().trim();
                    String chapter_txt = chapter.getSelectedItem().toString().trim();
                    String standard_txt = standard.getSelectedItem().toString().trim();
                    String test_type_txt = test_type.getSelectedItem().toString().trim();
                    String no_of_question_txt = no_of_question.getText().toString();


//                    questionList=question_ar/ray_list;

//                    QuestionData.setmAD_SMCQ();




//                    String folder = "MAD-IVA";
                    databaseReference = FirebaseDatabase.getInstance().getReference().child("root").child(standard_txt).child(subject_txt).child(chapter_txt).child(test_type_txt);
//                    databaseReference = FirebaseDatabase.getInstance().getReference().child(board+"/"+standard+"/"+subject_txt+"/"+chapter+"/"+test_type_txt);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.getChildrenCount()==0){
                                progressbarTimer.cancel();
                                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                                waitProgressbar.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), "currently question is  unavailable, would you like to contribute", Toast.LENGTH_SHORT).show();

                                return;
                            }
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                Log.w("asdf", "working");

                                switch (dataSnapshot.child("type").getValue(String.class)){

                                    case "MCQ":
                                        questionList.add(dataSnapshot.getValue(MCQ.class));
                                        break;
                                    case "NAT":
                                        questionList.add(dataSnapshot.getValue(NAT.class));
                                        break;
                                    case "SWA":

                                        questionList.add(dataSnapshot.getValue(SWA.class));
                                        break;
                                    case "IVA":
                                        questionList.add(dataSnapshot.getValue(IVA.class));

                                        break;


                                    default:
                                        break;
                                }
//                                  Log.d("-----", (dataSnapshot.getValue(Question.class).getClass().toString()));
                            }

                            Collections.shuffle(questionList);
                            intent.putExtra("list", (Serializable) questionList);
                            waitProgressbar.setVisibility(View.GONE);
                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                            progressbarTimer.cancel();
                            finish();
                            startActivity(intent);
                         }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            progressbarTimer.cancel();

                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            Toast.makeText(getApplicationContext(), "error while fetching data", Toast.LENGTH_SHORT).show();

                            return;
                        }


                    });





                }
            }
        });

    }

    void progressbar(){


         TimerTask  timerTask=new TimerTask() {
            @Override
            public void run() {
                progressbarCount++;

                Log.w("asdf", "progresss");
                waitProgressbar.setProgress(progressbarCount);
                if(progressbarCount>5){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "internet problem", Toast.LENGTH_SHORT).show();
                            progressbarTimer.cancel();
                            waitProgressbar.setVisibility(View.GONE);
                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


                        }
                    });


                     return;

                }
            }
        };
        progressbarTimer=new Timer();

        progressbarTimer.schedule(timerTask, 0, 1000);
    }


    void setSubject(){
        int std_selected_index=standard.getSelectedItemPosition();
        ArrayList<String> list_sub=new ArrayList<>();
        for(Trie std: Dir.getInstanceOfDir().child.get(0).child.get(std_selected_index).child ){
            list_sub.add(std.name);
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, list_sub);
        subject.setAdapter(adapter2);
    }

    void setChapter(){
                int std_selected_index=standard.getSelectedItemPosition();

                int sub_selected_index=subject.getSelectedItemPosition();
                ArrayList<String> list_chapter=new ArrayList<>();
                for(Trie cht: Dir.getInstanceOfDir().child.get(0).child.get(std_selected_index).child.get(sub_selected_index).child ){
                    list_chapter.add(cht.name);
                }
                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, list_chapter);
                chapter.setAdapter(adapter3);
//                subject.setSelection(adapter2.getPosition("MAD"));


    }

}