package com.example.quizapp.ui.addquestion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.M;
import com.example.quizapp.backend.Question.NVA;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.data.AllQuestion;
import com.example.quizapp.backend.data.DATA;
import com.example.quizapp.backend.firebase.FireBaseManager;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnSuccessListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NVAAddQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NVAAddQuestionFragment extends Fragment {
    EditText question, answer;
    Spinner creator;
    Button exit, submit;
    FireBaseManager fireBaseManager = new FireBaseManager();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NVAAddQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NVAAddQuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NVAAddQuestionFragment newInstance(String param1, String param2) {
        NVAAddQuestionFragment fragment = new NVAAddQuestionFragment();
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
        return inflater.inflate(R.layout.fragment_n_v_a_add_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        question=view.findViewById(R.id.question);
//        question=getView().findViewById(R.id.question);
        answer=getView().findViewById(R.id.answer);
        exit=getView().findViewById(R.id.exit);
        submit=getView().findViewById(R.id.submit);

        creator=getView().findViewById(R.id.creator);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, DATA.creator);
        creator.setAdapter(adapter1);
        creator.setSelection(adapter1.getPosition("Deepak"));



        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cr=((Spinner)getActivity().findViewById(R.id.creator)).getSelectedItem().toString();
                String sub=((Spinner)getActivity().findViewById(R.id.spinner_subject)).getSelectedItem().toString().trim();
                String qs=question.getText().toString().trim();
                String s_ans=answer.getText().toString().trim();

                if (cr.matches("") || sub.matches("") || qs.matches("") || s_ans.matches("")) {
                    Toast.makeText(getContext(), "Please fill in all the required fields.", Toast.LENGTH_SHORT).show();
                }

                else{
                    float ans=(float) Double.parseDouble(s_ans);
                    Question question=Question.createNVA(cr, sub, qs, ans);
//                    AllQuestion.allQuestion.add(question);

                    fireBaseManager.add(question).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getActivity(),"Success2",Toast.LENGTH_LONG).show();

                        }
                    }).addOnCanceledListener(new OnCanceledListener() {
                        @Override
                        public void onCanceled() {
                            Toast.makeText(getActivity(),"cancelled",Toast.LENGTH_LONG).show();

                        }
                    });

                    getActivity().finish();
                }


            }
        });


    }
}