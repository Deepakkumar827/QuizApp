package com.example.quizapp.ui.user;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.Question.SMCQ4;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IVAuserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SMCQ4userFragment extends Fragment {
    CardView card_question, card_opt1, card_opt2, card_opt3, card_opt4;
    TextView text_question, text_opt1, text_opt2, text_opt3, text_opt4;
    int index=0;
    ArrayList<String> answer_given;
    int total_question, question_unsolved, question_solved, question_wrong, question_correct;

    Question current_question;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SMCQ4userFragment(Question question) {
        // Required empty public constructor
        current_question=question;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IVAuserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IVAuserFragment newInstance(String param1, String param2) {
        IVAuserFragment fragment = new IVAuserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_s_m_c_q4user, container, false);



        return v;    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        card_question=getView().findViewById(R.id.card_question);
        card_opt1=getView().findViewById(R.id.card_opt1);
        card_opt2=getView().findViewById(R.id.card_opt2);
        card_opt3=getView().findViewById(R.id.card_opt3);
        card_opt4=getView().findViewById(R.id.card_opt4);

        text_question=getView().findViewById(R.id.text_question);
        text_opt1=getView().findViewById(R.id.text_opt1);
        text_opt2=getView().findViewById(R.id.text_opt2);
        text_opt3=getView().findViewById(R.id.text_opt3);
        text_opt4=getView().findViewById(R.id.text_opt4);


        SMCQ4 question=(SMCQ4) current_question;
        text_question.setText(question.getQuestion());
        text_opt1.setText(question.getChoice1());
        text_opt2.setText(question.getChoice2());
        text_opt3.setText(question.getChoice3());
        text_opt4.setText(question.getChoice4());


        index=((QuizDashboard)getActivity()).index;
        answer_given=((QuizDashboard)getActivity()).answer_given;
        if(answer_given.get(index)==""){
            setListener();
        }
        else{
            if(Integer.parseInt(answer_given.get(index))==((SMCQ4)current_question).getAnswer()){
                setCardColor(((SMCQ4)current_question).getAnswer(), Color.GREEN);
            }
            else{
                setCardColor(Integer.parseInt(answer_given.get(index)), Color.RED);
                setCardColor(((SMCQ4)current_question).getAnswer(), Color.GREEN);

            }
        }












    }

    void setListener(){
        SMCQ4 question=(SMCQ4) current_question;

        card_opt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(question.getAnswer()==1){
                    setCardColor(1,Color.GREEN);
                    update_top_bar(1);

                }
                else {
                    setCardColor(1,Color.RED);
                    setCardColor(question.getAnswer(),Color.GREEN);
                    update_top_bar(-1);

                }

                answer_given.set(index, Integer.toString(1));
                disableAllButton();

            }
        });
        card_opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(question.getAnswer()==2){
                    setCardColor(2,Color.GREEN);
                    update_top_bar(1);

                }
                else {
                    setCardColor(2,Color.RED);
                    setCardColor(question.getAnswer(),Color.GREEN);
                    update_top_bar(-1);


                }
                answer_given.set(index, Integer.toString(2));

                disableAllButton();
            }
        });


        card_opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question.getAnswer()==3){
                    setCardColor(3,Color.GREEN);
                    update_top_bar(1);

                }
                else {
                    setCardColor(3,Color.RED);
                    setCardColor(question.getAnswer(),Color.GREEN);

                    update_top_bar(-1);

                }
                answer_given.set(index, Integer.toString(3));

                disableAllButton();
            }
        });


        card_opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question.getAnswer()==4){
                    setCardColor(4,Color.GREEN);
                    update_top_bar(1);

                }
                else {
                    setCardColor(4,Color.RED);
                    setCardColor(question.getAnswer(),Color.GREEN);
                    update_top_bar(-1);


                }
                answer_given.set(index, Integer.toString(4));

                disableAllButton();
            }
        });
    }


    void setCardColor(int b, int color){
        switch (b){
            case 1:
                card_opt1.getBackground().setTint(color);

                break;
            case 2:
                card_opt2.getBackground().setTint(color);

                break;
            case 3:
                card_opt3.getBackground().setTint(color);

                break;
            case 4:
                card_opt4.getBackground().setTint(color);

                break;
            default:
                ///
        }


    }


    void disableAllButton(){
        card_opt1.setOnClickListener(null);
        card_opt2.setOnClickListener(null);
        card_opt3.setOnClickListener(null);
        card_opt4.setOnClickListener(null);
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























