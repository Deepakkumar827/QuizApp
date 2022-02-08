package com.example.quizapp.ui.user;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.MCQ;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.Question.SWA;

import java.util.ArrayList;
import java.util.Locale;

public class SWAuserFragment extends Fragment {
    TextView text_question;
    EditText text_user_ans;
    Button text_actual_ans_btn;
    Question current_question;
    int index=0;
    ArrayList<String> answer_given;
    int total_question, question_unsolved, question_solved, question_wrong, question_correct;



    public SWAuserFragment(Question question) {
        // Required empty public constructor
        current_question=question;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_s_w_auser, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        text_question=getView().findViewById(R.id.text_question);
        text_user_ans=getView().findViewById(R.id.user_answer);
        text_actual_ans_btn=getView().findViewById(R.id.set_button);

        SWA question=(SWA) current_question;
        text_question.setText(question.getQuestion());

        text_user_ans.setEnabled(false);

        index=((QuizDashboard)getActivity()).index;
        answer_given=((QuizDashboard)getActivity()).answer_given;
        if(answer_given.get(index)==""){
            text_user_ans.setEnabled(true);

            setListener();
        }
        else{

            if(answer_given.get(index).trim().toUpperCase(Locale.ROOT).equals(((SWA)current_question).getAnswer().trim().toUpperCase(Locale.ROOT))){
                text_user_ans.setBackgroundColor(Color.GREEN);
//                text_actual_ans_btn.getBackground().setTint(Color.GREEN);
            }
            else{
                text_user_ans.setBackgroundColor(Color.RED);
//                text_actual_ans_btn.getBackground().setTint(Color.RED);

            }

        }












    }

    void setListener(){
        SWA question=(SWA) current_question;

        text_actual_ans_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), question.getAnswer().trim().toLowerCase(Locale.ROOT).getClass()+"--+--"+text_user_ans.getText().toString().trim().toLowerCase(Locale.ROOT).getClass(), Toast.LENGTH_LONG).show();

                if(question.getAnswer().trim().toUpperCase(Locale.ROOT).equals(text_user_ans.getText().toString().trim().toUpperCase(Locale.ROOT))){
                    text_user_ans.setBackgroundColor(Color.GREEN);

//                    text_actual_ans_btn.getBackground().setTint(Color.GREEN);
                    update_top_bar(1);

                }
                else {
                     text_user_ans.setBackgroundColor(Color.RED);
                    update_top_bar(-1);

                }

                text_user_ans.setEnabled(false);

                answer_given.set(index, text_user_ans.getText().toString());
                text_actual_ans_btn.setOnClickListener(null);

            }
        });

    }









    void update_top_bar(int ans){



        if(ans<0){
            ((QuizDashboard)getActivity()).question_solved++;
            ((QuizDashboard)getActivity()).question_unsolved--;
            ((QuizDashboard)getActivity()).question_wrong++;


        }
        else if(ans>0){
            ((QuizDashboard)getActivity()).question_solved++;
            ((QuizDashboard)getActivity()).question_unsolved--;
            ((QuizDashboard)getActivity()).question_correct++;

        }
        else{

        }
        ((QuizDashboard)getActivity()).updateTopBar();


    }



}



