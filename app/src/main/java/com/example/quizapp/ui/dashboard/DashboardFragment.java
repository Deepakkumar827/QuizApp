package com.example.quizapp.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.IVA;
import com.example.quizapp.backend.Question.MCQ;
import com.example.quizapp.backend.Question.NAT;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.Question.SWA;
import com.example.quizapp.backend.data.DATA;
import com.example.quizapp.backend.data.Dir;
import com.example.quizapp.backend.data.Trie;
import com.example.quizapp.backend.firebase.FireBaseManager;
import com.example.quizapp.databinding.FragmentDashboardBinding;
import com.example.quizapp.ui.user.QuizDashboard;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class DashboardFragment extends Fragment {
    Button exit, ok;
    ProgressBar waitProgressbar;
    Timer progressbarTimer;
    int  progressbarCount=0;
    EditText no_of_question;
    Spinner standard, test_type, subject, chapter;
    List<Question> questionList;
     DatabaseReference databaseReference;
    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });




        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        standard = getView().findViewById(R.id.standard);
        subject = getView().findViewById(R.id.subject);
        no_of_question = getView().findViewById(R.id.no_of_question);
        test_type = getView().findViewById(R.id.test_type);
        chapter = getView().findViewById(R.id.chapter);

        no_of_question.setText("111111");
        no_of_question.setEnabled(false);

        exit = getView().findViewById(R.id.exit);
        ok = getView().findViewById(R.id.submit);
        waitProgressbar=getView().findViewById(R.id.quiz_manager_progressbar);
        progressbarTimer=new Timer();




        ArrayList<String> list_std=new ArrayList<>();
        for(Trie std: Dir.getInstanceOfDir().child.get(0).child ){
            list_std.add(std.name);
        }
        for(String s:list_std){
            Log.w("asdf--", s );

        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item,list_std );
        standard.setAdapter(adapter1);


        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, DATA.test_type);
        test_type.setAdapter(adapter3);
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




        Bundle bundle = getActivity().getIntent().getExtras();
//        if(!bundle.get("subject").toString().trim().matches("")){
//            subject.setSelection(adapter1.getPosition(bundle.get("subject").toString()));
//
//
//        }
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().onBackPressed();
                requireActivity().onBackPressed();

            }
        });

        questionList = new ArrayList<>();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                databaseReference=null;
                questionList=new ArrayList<>();
                progressbarCount = 0;
                waitProgressbar.setVisibility(View.VISIBLE);

                progressbar();
                Intent intent = new Intent(getContext(), QuizDashboard.class);
                if (no_of_question.getText().toString().trim().matches("") || Integer.parseInt(no_of_question.getText().toString().trim()) == 0) {
                    Toast.makeText(getContext(), "Please fill in all the required fields.", Toast.LENGTH_SHORT).show();
                } else {
                    String subject_txt = subject.getSelectedItem().toString().trim();
                    String chapter_txt = chapter.getSelectedItem().toString().trim();
                    String standard_txt = standard.getSelectedItem().toString().trim();
                    String test_type_txt = test_type.getSelectedItem().toString().trim();
                    String no_of_question_txt = no_of_question.getText().toString();


//                    questionList=question_ar/ray_list;

//                    QuestionData.setmAD_SMCQ();




//                    String folder = "MAD-IVA";
                    databaseReference = FirebaseDatabase.getInstance().getReference().child("Root").child(standard_txt).child(subject_txt).child(chapter_txt).child(test_type_txt);
//                    databaseReference = FirebaseDatabase.getInstance().getReference().child(board+"/"+standard+"/"+subject_txt+"/"+chapter+"/"+test_type_txt);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.getChildrenCount()==0){
                                progressbarTimer.cancel();
                                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                                waitProgressbar.setVisibility(View.GONE);
                                Toast.makeText(getContext(), "currently question is  unavailable, would you like to contribute", Toast.LENGTH_SHORT).show();

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
                            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                             progressbarTimer.cancel();
//                            getActivity().finish();
                            startActivity(intent);
                            getActivity().onBackPressed();

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                             progressbarTimer.cancel();
                            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            Toast.makeText(getContext(), "error while fetching data", Toast.LENGTH_LONG).show();
//                            getActivity().finish();

                            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                        }


                    });





                }
            }
        });

    }

    void progressbar(){


        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                progressbarCount++;

                Log.w("asdf", "progresss");
                waitProgressbar.setProgress(progressbarCount);
                if(progressbarCount>15){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(), "internet problem", Toast.LENGTH_SHORT).show();
                            progressbarTimer.cancel();
                            waitProgressbar.setVisibility(View.GONE);
                            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

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
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, list_sub);
        subject.setAdapter(adapter2);
    }

    void setChapter(){
        int std_selected_index=standard.getSelectedItemPosition();

        int sub_selected_index=subject.getSelectedItemPosition();
        ArrayList<String> list_chapter=new ArrayList<>();
        for(Trie cht: Dir.getInstanceOfDir().child.get(0).child.get(std_selected_index).child.get(sub_selected_index).child ){
            list_chapter.add(cht.name);
        }
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, list_chapter);
        chapter.setAdapter(adapter3);
//                subject.setSelection(adapter2.getPosition("MAD"));


    }

}