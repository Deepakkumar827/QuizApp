package com.example.quizapp.backend.firebase;

import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.quizapp.backend.Question.IVA;
import com.example.quizapp.backend.Question.NVA;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.Question.SMCQ4;
import com.example.quizapp.backend.Question.SWA;
import com.example.quizapp.ui.user.QuizManager;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FireBaseManager {
    List<Question> questionList=new ArrayList<>();

    private DatabaseReference databaseReference;
    public FireBaseManager(){
    }

    public Task<Void> add(Object object){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        databaseReference=db.getReference(Object.class.getSimpleName());
        return databaseReference.push().setValue(object);
    }

    public Task<Void> addQuestion(Question question){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        databaseReference=db.getReference(question.getSubject()+"-"+question.getType());
         return databaseReference.push().setValue(question);
    }





}

































/*

    public void getQuestion(String subject, String type){
        databaseReference=FirebaseDatabase.getInstance().getReference("test");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Question question=dataSnapshot.getValue(Question.class);

                    questionList.add(question);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    */
