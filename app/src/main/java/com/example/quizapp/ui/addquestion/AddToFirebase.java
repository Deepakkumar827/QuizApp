package com.example.quizapp.ui.addquestion;

import android.content.DialogInterface;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.data.QuestionData;
import com.example.quizapp.backend.firebase.FireBaseManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class AddToFirebase {
    static AlertDialog.Builder builder;




    public static void add(FragmentActivity activity, Question question){



        builder = new AlertDialog.Builder(activity);
        Toast.makeText(activity.getApplicationContext(),"Please Wait",Toast.LENGTH_LONG).show();

        FireBaseManager fireBaseManager=new FireBaseManager();
        /*for(Question q: QuestionData.mAD_SMCQ){
            fireBaseManager.add(q);
        }
        if (1==1){
            return;
        }*/



        if(question instanceof Question) {
            showalert(activity, question, fireBaseManager.addQuestion(question));
        }
        else if(question != null) {
            showalert(activity, question, fireBaseManager.add(question));
        }

        else{
            Toast.makeText(activity.getApplicationContext(), "trying to add null object", Toast.LENGTH_LONG).show();
        }




    }

    private static void showalert(FragmentActivity activity, Question question, Task<Void> task){
        task.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {


                //Setting message manually and performing action on button click
                builder.setMessage("Success")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                activity.finish();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Notification");
                alert.show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(activity.getApplicationContext(),"FAILED",Toast.LENGTH_LONG).show();

            }
        });
    }









}

