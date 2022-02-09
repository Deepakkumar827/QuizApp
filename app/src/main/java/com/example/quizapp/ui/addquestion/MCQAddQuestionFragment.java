package com.example.quizapp.ui.addquestion;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.firebase.FireBaseManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MCQAddQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MCQAddQuestionFragment extends Fragment {

    TextView creator;
    Button exit, submit;
    EditText question, option1, option2, option3, option4, message;
    Spinner answer;
    static Integer[] optanswer=new Integer[]{1, 2, 3, 4};
    FireBaseManager fireBaseManager = new FireBaseManager();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MCQAddQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MCQAddQuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MCQAddQuestionFragment newInstance(String param1, String param2) {
        MCQAddQuestionFragment fragment = new MCQAddQuestionFragment();
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
        return inflater.inflate(R.layout.fragment_s_m_c_q4_add_question, container, false);
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
        message=view.findViewById(R.id.message);


        answer=getView().findViewById(R.id.answer);
        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<Integer>(getActivity(), android.R.layout.simple_spinner_dropdown_item, optanswer);
        answer.setAdapter(adapter2);
        answer.setSelection(adapter2.getPosition(1));

        option1=getView().findViewById(R.id.option1);
        option2=getView().findViewById(R.id.option2);
        option3=getView().findViewById(R.id.option3);
        option4=getView().findViewById(R.id.option4);
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
                String sub=((Spinner)getActivity().findViewById(R.id.spinner_subject)).getSelectedItem().toString();
                String qs=question.getText().toString().trim();
                String opt1=option1.getText().toString().trim();
                String opt2=option2.getText().toString().trim();
                String opt3=option3.getText().toString().trim();
                String opt4=option4.getText().toString().trim();
                String s_ans=answer.getSelectedItem().toString().trim();
                String msg=message.getText().toString().trim();


                if (cr.matches("") || sub.matches("") || qs.matches("") || opt1.matches("") || opt2.matches("") || opt3.matches("") || opt4.matches("") || s_ans.matches("") ||  msg.matches("")) {
                    Toast.makeText(getContext(), "Please fill in all the required fields.", Toast.LENGTH_SHORT).show();
                }
                else {
                    int check=0;
                    int  ans=Integer.parseInt(s_ans);
                    Question question=Question.createMCQ(cr,"all","all",  sub, "prev", "chapter", qs,opt1, opt2, opt3, opt4, ans, msg);
                     AddToFirebase.add(getActivity(), question);

//                    for(Question q: QuestionData.mAD_SMCQ){
//                        AddToFirebase.add(getActivity(), q);
//                    }

                }
            }
        });
    }
}
