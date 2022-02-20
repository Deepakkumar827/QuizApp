package com.example.quizapp.ui.Dashboard2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.IVA;
import com.example.quizapp.backend.Question.MCQ;
import com.example.quizapp.backend.Question.NAT;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.Question.SWA;
import com.example.quizapp.backend.data.Dir;
import com.example.quizapp.backend.data.Trie;
import com.example.quizapp.databinding.FragmentDashboard2Binding;
import com.example.quizapp.ui.home.MyAdapter;
import com.example.quizapp.ui.user.QuizDashboard;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Dashboard2Fragment extends Fragment implements CardClicked {
    RecyclerView recyclerView;

    int test = 0;
    FragmentDashboard2Binding binding;

    Spinner standard;
    Trie subjectParentTrie;
    List<Question> questionList;
    ArrayList<CardData> cardDataArrayList = new ArrayList<>();
    DatabaseReference databaseReference;
    Timer progressbarTimer;
    int progressbarCount = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDashboard2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        standard = getView().findViewById(R.id.spinner_standard);


        ArrayList<String> list_std = new ArrayList<>();
        for (Trie std : Dir.getInstanceOfDir().child.get(0).child) {
            list_std.add(std.name);
        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, list_std);
        standard.setAdapter(adapter1);
        standard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                cardDataArrayList.clear();
                ///TODO: here ...Dir.getInstanceOfDir().child.get(0).child.get(standard.getSelectedItemPosition()) is not a wise step, it should be search by string not index;

                subjectParentTrie = Dir.getInstanceOfDir().child.get(0).child.get(position);


                for (Trie subject : subjectParentTrie.child) {
                    for (Trie chapter : subject.child) {
                        for (Trie type : chapter.child) {
                            cardDataArrayList.add(new CardData("Root", subjectParentTrie.name, subject.name, chapter.name, type.name, test++));
                        }

                    }

                }


                setCardList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    void setCardList() {

        recyclerView = getView().findViewById(R.id.main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Dashboard2ViewAdapter adapter = new Dashboard2ViewAdapter(cardDataArrayList, getActivity(), this);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onCardClicked(CardData cardData) {

        ArrayList<String>type_list=new ArrayList<>();

        databaseReference = null;
        questionList = new ArrayList<>();
        progressbarCount = 0;

        if (cardData.type == "MCQ" || cardData.type == "IVA" || cardData.type == "NAT" || cardData.type == "SWA") {

            type_list.add(cardData.type);
        } else if (cardData.type == "Mixed") {

            type_list.add("MCQ");
            type_list.add("IVA");
            type_list.add("NAT");
            type_list.add("SWA");
        } else {
            Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
            return;

        }


        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        binding.dashboardboard2Progressbar.setVisibility(View.VISIBLE);


        progressbar();
        Intent intent = new Intent(getContext(), QuizDashboard.class);



        databaseReference = FirebaseDatabase.getInstance().getReference().child("Root").child(cardData.standard).child(cardData.subject).child(cardData.chapter);
//                    databaseReference = FirebaseDatabase.getInstance().getReference().child(board+"/"+standard+"/"+subject_txt+"/"+chapter+"/"+test_type_txt);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getChildrenCount() == 0) {
                    progressbarTimer.cancel();
                    getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                    binding.dashboardboard2Progressbar.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "currently question is  unavailable, would you like to contribute", Toast.LENGTH_SHORT).show();

                    return;
                }

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    for (DataSnapshot childsnapshot : dataSnapshot.getChildren()) {
                        Log.w("asddf", "working1");
                        if(!(type_list.contains(childsnapshot.child("type").getValue(String.class)))){continue;};

                        switch (childsnapshot.child("type").getValue(String.class)) {

                            case "MCQ":
                                questionList.add(childsnapshot.getValue(MCQ.class));
                                break;
                            case "NAT":
                                questionList.add(childsnapshot.getValue(NAT.class));
                                break;
                            case "SWA":

                                questionList.add(childsnapshot.getValue(SWA.class));
                                break;
                            case "IVA":
                                questionList.add(childsnapshot.getValue(IVA.class));

                                break;


                            default:
                                break;
                        }
                    }
//                                  Log.d("-----", (dataSnapshot.getValue(Question.class).getClass().toString()));
                }
                snapshot = null;  ////TODO: without using this, snapshot gives previous result, i dont know why?

                Collections.shuffle(questionList);
                intent.putExtra("list", (Serializable) questionList);
                binding.dashboardboard2Progressbar.setVisibility(View.GONE);
                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                progressbarTimer.cancel();
                if(questionList.size()==0){
                    Toast.makeText(getContext(), "currently question is  unavailable, would you like to contribute", Toast.LENGTH_SHORT).show();
                    return;
                }
//                            getActivity().finish();
                startActivity(intent);
//                getActivity().onBackPressed();

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


    void progressbar() {


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                progressbarCount++;

                 binding.dashboardboard2Progressbar.setProgress(progressbarCount);
                if (progressbarCount > 15) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(), "internet problem", Toast.LENGTH_SHORT).show();
                            progressbarTimer.cancel();
                            binding.dashboardboard2Progressbar.setVisibility(View.GONE);
                            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                        }
                    });


                    return;
                }
            }
        };
        progressbarTimer = new Timer();

        progressbarTimer.schedule(timerTask, 0, 1000);
    }

}
