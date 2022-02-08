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

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.IVA;
import com.example.quizapp.backend.Question.Question;

import java.util.ArrayList;
import java.util.Locale;

public class IVAuserFragment extends Fragment {
    TextView text_question;
    EditText text_user_ans;
    Button text_actual_ans_btn;
    Question current_question;
    int index = 0;
    ArrayList<String> answer_given;
    int total_question, question_unsolved, question_solved, question_wrong, question_correct;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IVAuserFragment(Question question) {
        // Required empty public constructor
        current_question = question;
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
        return inflater.inflate(R.layout.fragment_i_v_auser, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        text_question = getView().findViewById(R.id.text_question);
        text_user_ans = getView().findViewById(R.id.user_answer);
        text_actual_ans_btn = getView().findViewById(R.id.set_button);

        IVA question = (IVA) current_question;
        text_question.setText(question.getQuestion());

        text_user_ans.setEnabled(false);

        index = ((QuizDashboard) getActivity()).index;
        answer_given = ((QuizDashboard) getActivity()).answer_given;
        if (answer_given.get(index) == "") {
            text_user_ans.setEnabled(true);

            setListener();
        } else {
            if (Integer.parseInt(answer_given.get(index)) == ((IVA) current_question).getAnswer()) {
                text_user_ans.getBackground().setTint(Color.GREEN);
//                text_actual_ans_btn.getBackground().setTint(Color.GREEN);
            } else {
                text_user_ans.getBackground().setTint(Color.RED);
//                text_actual_ans_btn.getBackground().setTint(Color.RED);

            }
        }


    }

    void setListener() {
        IVA question = (IVA) current_question;

        text_actual_ans_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (question.getAnswer() == Integer.parseInt(text_user_ans.getText().toString())) {
                    text_user_ans.getBackground().setTint(Color.GREEN);
//                    text_actual_ans_btn.getBackground().setTint(Color.GREEN);
                    update_top_bar(1);

                } else {
                    text_user_ans.getBackground().setTint(Color.RED);
//                    text_actual_ans_btn.getBackground().setTint(Color.RED);
                    update_top_bar(-1);

                }

                answer_given.set(index, text_user_ans.getText().toString());
                text_actual_ans_btn.setOnClickListener(null);
                text_user_ans.setEnabled(false);

            }

        });

    }


    void update_top_bar(int ans) {


        if (ans < 0) {
            ((QuizDashboard) getActivity()).question_solved++;
            ((QuizDashboard) getActivity()).question_unsolved--;
            ((QuizDashboard) getActivity()).question_wrong++;


        } else if (ans > 0) {
            ((QuizDashboard) getActivity()).question_solved++;
            ((QuizDashboard) getActivity()).question_unsolved--;
            ((QuizDashboard) getActivity()).question_correct++;

        } else {

        }
        ((QuizDashboard) getActivity()).updateTopBar();


    }


}

