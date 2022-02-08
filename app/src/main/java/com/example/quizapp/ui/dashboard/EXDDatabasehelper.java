package com.example.quizapp.ui.dashboard;

import android.util.Log;

import com.example.quizapp.backend.Question.IVA;
import com.example.quizapp.backend.Question.MCQ;
import com.example.quizapp.backend.Question.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class EXDDatabasehelper {

    private DatabaseReference mDatabase;
    MCQ result;

    public EXDDatabasehelper() {
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // We create a query
        Query query = mDatabase.child("MAD-SMCQ4");

        //We recive query
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    Log.w("asdf", "TESTING");
                    try {
                        Log.w("asdf", userSnapshot.toString());

//                         Deserializing only name
                        String name = userSnapshot.child("choice3").getValue(String.class);
                        Log.w("asdf", "W1" + name);

                       /* // Deserializing only phone
                        String phone = userSnapshot.child("born").getValue(String.class);
                        Log.w("asdf", "Long is here!!!" + phone);
*/
                        // Deserializing into a TestData object
                        MCQ result =  userSnapshot.getValue(MCQ.class);
                        Log.w("asdf", "W2");






 /*
                        Log.w("asdf", result.getBorn()+result.getFirst()+result.getTitle()+result.getClass());
*/



                    } catch (Exception e) {
                        Log.w("asdf", "Parse failed", e);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("asdf", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });


    }
}































































/*
package com.example.quizapp.ui.dashboard;

        import android.util.Log;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.Query;
        import com.google.firebase.database.ValueEventListener;

public class EXDDatabasehelper {

    private DatabaseReference mDatabase;
    EXample result;

    public EXDDatabasehelper() {
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // We create a query
        Query query = mDatabase.child(EXample.class.getSimpleName());

        //We recive query
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    Log.w("asdf", "Tenemos el resultado de la query.");
                    try {
                        Log.w("asdf", userSnapshot.toString());

                        // Deserializing only name
                        String name = userSnapshot.child("first").getValue(String.class);
                        Log.w("asdf", "String is here!!!" + name);

                        // Deserializing only phone
                        String phone = userSnapshot.child("born").getValue(String.class);
                        Log.w("asdf", "Long is here!!!" + phone);

                        // Deserializing into a TestData object
                        EXample result = userSnapshot.getValue(EXample.class);
                        Log.w("asdf", "Parse success!!!");
                        Log.w("asdf", result.getBorn()+result.getFirst()+result.getTitle()+result.getClass());



                    } catch (Exception e) {
                        Log.w("asdf", "Parse failed", e);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("asdf", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });


    }
}*/
