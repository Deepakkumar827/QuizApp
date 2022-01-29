package com.example.quizapp.backend.firebase;

import android.app.ActivityManager;

import com.example.quizapp.backend.Question.IVA;
import com.example.quizapp.backend.Question.NVA;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.Question.SMCQ4;
import com.example.quizapp.backend.Question.SWA;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseManager {
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
        databaseReference=db.getReference(Question.class.getSimpleName());
        return databaseReference.push().setValue(question);
    }

public Task<Void> addIVA(IVA question){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        databaseReference=db.getReference(IVA.class.getSimpleName());
        return databaseReference.push().setValue(question);
    }

    public Task<Void> addSMCQ4(SMCQ4 question){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        databaseReference=db.getReference(SMCQ4.class.getSimpleName());
        return databaseReference.push().setValue(question);
    }

    public Task<Void> addSWA(SWA question){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        databaseReference=db.getReference(SWA.class.getSimpleName());
        return databaseReference.push().setValue(question);
    }

    public Task<Void> addNVA(NVA question){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        databaseReference=db.getReference(NVA.class.getSimpleName());
        return databaseReference.push().setValue(question);
    }


}
