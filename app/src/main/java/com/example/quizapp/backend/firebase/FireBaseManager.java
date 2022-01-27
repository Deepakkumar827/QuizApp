package com.example.quizapp.backend.firebase;

import android.app.ActivityManager;

import com.example.quizapp.backend.Question.Question;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseManager {
    private DatabaseReference databaseReference;
    public FireBaseManager(){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        databaseReference=db.getReference(Question.class.getSimpleName());
    }

    public Task<Void> add(Question question){
        return databaseReference.push().setValue(question);
    }
}
