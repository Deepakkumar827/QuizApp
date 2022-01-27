package com.example.quizapp.ui.addquestion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.backend.data.DATA;


public class AddQuestionDashboard extends AppCompatActivity {


    private Spinner  subjectspinner, quesionspinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question_manager);

        subjectspinner=findViewById(R.id.spinner_subject);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, DATA.subject);
        subjectspinner.setAdapter(adapter1);
        subjectspinner.setSelection(adapter1.getPosition("MAD"));

        quesionspinner=findViewById(R.id.spinner_question_type);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, DATA.questiontype);
        quesionspinner.setAdapter(adapter2);
        quesionspinner.setSelection(adapter2.getPosition("IVA"));


//        IVAAddQuestionFragment fragment3=new IVAAddQuestionFragment();
//        FragmentTransaction transaction3=getSupportFragmentManager().beginTransaction();
//        transaction3.replace(R.id.add_question_dashboard_fragment, fragment3);
//        transaction3.commit();


        subjectspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected=quesionspinner.getSelectedItem().toString().trim();
                switch (selected){
                    case "SWA":
                        SWAAddQuestionFragment fragment1=new SWAAddQuestionFragment();
                        FragmentTransaction transaction1=getSupportFragmentManager().beginTransaction();
                        transaction1.replace(R.id.add_question_dashboard_fragment, fragment1);
                        transaction1.commit();

                        break;
                    case "SMCQ4":
                        SMCQ4AddQuestionFragment fragment2=new SMCQ4AddQuestionFragment();
                        FragmentTransaction transaction2=getSupportFragmentManager().beginTransaction();
                        transaction2.replace(R.id.add_question_dashboard_fragment, fragment2);
                        transaction2.commit();

                        break;
                    case "IVA":
                        IVAAddQuestionFragment fragment3=new IVAAddQuestionFragment();
                        FragmentTransaction transaction3=getSupportFragmentManager().beginTransaction();
                        transaction3.replace(R.id.add_question_dashboard_fragment, fragment3);
                        transaction3.commit();

                        break;
                    case "NVA":
                        NVAAddQuestionFragment fragment4=new NVAAddQuestionFragment();
                        FragmentTransaction transaction4=getSupportFragmentManager().beginTransaction();
                        transaction4.replace(R.id.add_question_dashboard_fragment, fragment4);
                        transaction4.commit();

                        break;
                    case "MMCQ4":
                        MMCQ4AddQuestionFragment fragment5=new MMCQ4AddQuestionFragment();
                        FragmentTransaction transaction5=getSupportFragmentManager().beginTransaction();
                        transaction5.replace(R.id.add_question_dashboard_fragment, fragment5);
                        transaction5.commit();

                        break;

                    default:
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        quesionspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected=quesionspinner.getSelectedItem().toString().trim();
                switch (selected){
                    case "SWA":
                        SWAAddQuestionFragment fragment1=new SWAAddQuestionFragment();
                        FragmentTransaction transaction1=getSupportFragmentManager().beginTransaction();
                        transaction1.replace(R.id.add_question_dashboard_fragment, fragment1);
                        Toast.makeText(getApplicationContext(),"from addqmanager", Toast.LENGTH_SHORT).show();
                        transaction1.commit();

                        break;
                    case "SMCQ4":
                        SMCQ4AddQuestionFragment fragment2=new SMCQ4AddQuestionFragment();
                        FragmentTransaction transaction2=getSupportFragmentManager().beginTransaction();
                        transaction2.replace(R.id.add_question_dashboard_fragment, fragment2);
                        transaction2.commit();

                        break;
                    case "IVA":
                        IVAAddQuestionFragment fragment3=new IVAAddQuestionFragment();
                        FragmentTransaction transaction3=getSupportFragmentManager().beginTransaction();
                        transaction3.replace(R.id.add_question_dashboard_fragment, fragment3);
                        transaction3.commit();

                        break;
                    case "NVA":
                        NVAAddQuestionFragment fragment4=new NVAAddQuestionFragment();
                        FragmentTransaction transaction4=getSupportFragmentManager().beginTransaction();
                        transaction4.replace(R.id.add_question_dashboard_fragment, fragment4);
                        transaction4.commit();

                        break;
                    case "MMCQ4":
                        MMCQ4AddQuestionFragment fragment5=new MMCQ4AddQuestionFragment();
                        FragmentTransaction transaction5=getSupportFragmentManager().beginTransaction();
                        transaction5.replace(R.id.add_question_dashboard_fragment, fragment5);
                        transaction5.commit();

                        break;

                    default:
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}