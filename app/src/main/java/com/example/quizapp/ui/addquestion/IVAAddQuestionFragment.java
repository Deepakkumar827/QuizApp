package com.example.quizapp.ui.addquestion;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.firebase.FireBaseManager;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class IVAAddQuestionFragment extends Fragment {
    EditText  question, answer, message;
    Button exit, submit;
    FireBaseManager fireBaseManager=new FireBaseManager();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    public IVAAddQuestionFragment() {
        // Required empty public constructor
    }

    public static IVAAddQuestionFragment newInstance(String param1, String param2) {
        IVAAddQuestionFragment fragment = new IVAAddQuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_i_v_a_add_question, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        question=view.findViewById(R.id.question);
//        question=getView().findViewById(R.id.question);
        answer=getView().findViewById(R.id.answer);
        exit=getView().findViewById(R.id.exit);
        submit=getView().findViewById(R.id.submit);
        message=view.findViewById(R.id.message);






        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                String cr=AddQuestionDashboard.device_id;
                String std=((Spinner)getActivity().findViewById(R.id.spinner_standard)).getSelectedItem().toString().trim();
                String sub=((Spinner)getActivity().findViewById(R.id.spinner_subject)).getSelectedItem().toString().trim();
                String chapter=((Spinner)getActivity().findViewById(R.id.spinner_chapter)).getSelectedItem().toString().trim();
                String qs=question.getText().toString().trim();
                String s_ans=answer.getText().toString().trim();
                String msg=message.getText().toString().trim();

                if (cr.matches("")  || std.matches("") || sub.matches("") || chapter.matches("")  || qs.matches("") || s_ans.matches("") || msg.matches("")) {
                    Toast.makeText(getContext(), "Please fill in all the required fields.", Toast.LENGTH_SHORT).show();
                }
                else{
                    int ans=Integer.parseInt(s_ans);
                    Question question=Question.createIVA(cr,"root",std,  sub, chapter, qs, ans, msg);

//                    Test.abc();

                   AddToFirebase.add(getActivity(), question);
                }

            }
        });


    }
}