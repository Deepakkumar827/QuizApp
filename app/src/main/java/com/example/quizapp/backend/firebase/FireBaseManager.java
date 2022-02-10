package com.example.quizapp.backend.firebase;

import com.example.quizapp.backend.Question.Question;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
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
//        databaseReference=db.getReference(question.getSubject()+"-"+question.getType());
        databaseReference=db.getReference(question.getBoard()+"/"+question.getStandard()+"/"+question.getSubject()+"/"+question.getChapter()+"/"+question.getType());
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
