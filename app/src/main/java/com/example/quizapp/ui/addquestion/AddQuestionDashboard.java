package com.example.quizapp.ui.addquestion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.backend.data.DATA;
import com.example.quizapp.backend.data.Dir;
import com.example.quizapp.backend.data.Trie;

import java.util.ArrayList;


public class AddQuestionDashboard extends AppCompatActivity {

    public static String device_id;

    public Spinner spinner_subject, spinner_question_type, spinner_standard, spinner_chapter;
    TextView creater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question_manager);

        creater=findViewById(R.id.creator);
        device_id=Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        creater.setText("Device ID: " +device_id);

        spinner_subject =findViewById(R.id.spinner_subject);
        spinner_chapter=findViewById(R.id.spinner_chapter);
        spinner_standard=findViewById(R.id.spinner_standard);

        spinner_question_type =findViewById(R.id.spinner_question_type);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, DATA.questiontype);
        spinner_question_type.setAdapter(adapter2);
        spinner_question_type.setSelection(adapter2.getPosition("IVA"));


        ArrayList<String> list_std=new ArrayList<>();
        for(Trie std: Dir.getInstanceOfDir().child.get(0).child ){
            list_std.add(std.name);
        }
        for(String s:list_std){
            Log.w("asdf--", s );

        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,list_std );
        spinner_standard.setAdapter(adapter1);

//        IVAAddQuestionFragment fragment3=new IVAAddQuestionFragment();
//        FragmentTransaction transaction3=getSupportFragmentManager().beginTransaction();
//        transaction3.replace(R.id.add_question_dashboard_fragment, fragment3);
//        transaction3.commit();

/*
        */

        spinner_standard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                setSubject();
                spinnerChange();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                setChapter();
                spinnerChange();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_question_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerChange();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    void setSubject(){
        int std_selected_index=spinner_standard.getSelectedItemPosition();
        ArrayList<String> list_sub=new ArrayList<>();
        for(Trie std: Dir.getInstanceOfDir().child.get(0).child.get(std_selected_index).child ){
            list_sub.add(std.name);
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, list_sub);
        spinner_subject.setAdapter(adapter2);
    }

    void setChapter(){
        int std_selected_index=spinner_standard.getSelectedItemPosition();

        int sub_selected_index=spinner_subject.getSelectedItemPosition();
        ArrayList<String> list_chapter=new ArrayList<>();
        for(Trie cht: Dir.getInstanceOfDir().child.get(0).child.get(std_selected_index).child.get(sub_selected_index).child ){
            list_chapter.add(cht.name);
        }
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, list_chapter);
        spinner_chapter.setAdapter(adapter3);
//                subject.setSelection(adapter2.getPosition("MAD"));


    }

    void spinnerChange() {

        String selected = spinner_question_type.getSelectedItem().toString().trim();
        switch (selected) {
            case "SWA":
                SWAAddQuestionFragment fragment1 = new SWAAddQuestionFragment();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.add_question_dashboard_fragment, fragment1);
                transaction1.commit();

                break;
            case "MCQ":
                MCQAddQuestionFragment fragment2 = new MCQAddQuestionFragment();
                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.add_question_dashboard_fragment, fragment2);
                transaction2.commit();

                break;
            case "IVA":
                IVAAddQuestionFragment fragment3 = new IVAAddQuestionFragment();
                FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                transaction3.replace(R.id.add_question_dashboard_fragment, fragment3);
                transaction3.commit();

                break;
            case "NAT":
                NVAAddQuestionFragment fragment4 = new NVAAddQuestionFragment();
                FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();
                transaction4.replace(R.id.add_question_dashboard_fragment, fragment4);
                transaction4.commit();

                break;
            case "MSQ":
                MSQAddQuestionFragment fragment5 = new MSQAddQuestionFragment();
                FragmentTransaction transaction5 = getSupportFragmentManager().beginTransaction();
                transaction5.replace(R.id.add_question_dashboard_fragment, fragment5);
                transaction5.commit();

                break;

            default:
                break;
        }
    }



}