package com.example.quizapp.ui.user;

import androidx.appcompat.app.AlertDialog;

import android.Manifest;
import android.content.DialogInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.IVA;
import com.example.quizapp.backend.Question.NAT;
import com.example.quizapp.backend.Question.Question;
import com.example.quizapp.backend.Question.MCQ;
import com.example.quizapp.backend.Question.SWA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizDashboard extends AppCompatActivity {
    /////////////
    ArrayList<String> only_question_list_string = new ArrayList<>();

    ArrayList<String> answer_given;
    List<Question> questionList;
    int index = -1;
    ProgressBar progressBar;
    CountDownTimer countDownTimer;
    int timervalue = 0;
    MCQ current;
    Spinner question_list_spinner;
    Button btn_prev, btn_middle, btn_next;
    int total_question, question_unsolved, question_solved, question_wrong, question_correct;
    TextView timer, total_question_txt, question_unsolved_txt, question_solved_txt, question_wrong_txt, question_correct_txt, screenshot_textview_btn;
    int timelimit_min = 600;
    AlertDialog.Builder builder;
    AlertDialog.Builder builderBackAlert;
    AlertDialog.Builder builderBackAlert2;
    File imagePath;
    File todeletefile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dashboard);
        btn_prev = findViewById(R.id.btn_prev);
        btn_middle = findViewById(R.id.btn_middle);
        btn_next = findViewById(R.id.btn_next);
        timer = findViewById(R.id.timer);
        builder = new AlertDialog.Builder(QuizDashboard.this);
        builderBackAlert = new AlertDialog.Builder(QuizDashboard.this);
        builderBackAlert2 = new AlertDialog.Builder(QuizDashboard.this);


        total_question_txt = findViewById(R.id.question_total);
        question_solved_txt = findViewById(R.id.question_total_solved);
        question_unsolved_txt = findViewById(R.id.question_unsolved);
        question_correct_txt = findViewById(R.id.question_correct);
        question_wrong_txt = findViewById(R.id.question_wrong);
        screenshot_textview_btn = findViewById(R.id.screenshot_textview_btn);
        question_list_spinner = findViewById(R.id.question_list_spinner);


        screenshot_textview_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(QuizDashboard.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) && PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(QuizDashboard.this, Manifest.permission.READ_EXTERNAL_STORAGE))) {
                    ActivityCompat.requestPermissions(QuizDashboard.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

                    return;
                }
                share(screenShot(findViewById(R.id.layout_for_screenshot)));

                Log.w("asdf", "7711");


            }
        });

        questionList = (List<Question>) (getIntent().getSerializableExtra("list"));
        answer_given = new ArrayList<>(Arrays.asList(new String[questionList.size()]));

        Collections.fill(answer_given, "");
        callNext(questionList, ++index);

        total_question = questionList.size();
        question_unsolved = questionList.size();
        question_solved = 0;
        question_wrong = 0;
        question_correct = 0;
        updateTopBar();

        int i=1;
        for(Question question: questionList){
            switch (question.getType()){
                case "MCQ":
                    only_question_list_string.add(i++ +" : "+ ((MCQ)question).getQuestion());
                    break;
                case "IVA":
                    only_question_list_string.add(i++ +" : "+ ((IVA)question).getQuestion());
                    break;
                case "SWA":
                    only_question_list_string.add(i++ +" : "+ ((SWA)question).getQuestion());
                    break;
                case "NAT":
                    only_question_list_string.add(i++ +" : "+ ((NAT)question).getQuestion());
                    break;

                default:
                    ////
                    break;

            }
        }

        ArrayAdapter<String> adapter_for_question_spinner= new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,only_question_list_string );
        question_list_spinner.setAdapter(adapter_for_question_spinner);





        countDownTimer = new CountDownTimer(timelimit_min * 60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timervalue++;
                timer.setText(timervalue / 3600 + ":" + (timervalue % 3600) / 60 + ":" + ((timervalue % 3600) % 60));
            }

            @Override
            public void onFinish() {

               /* Dialog dialog=new Dialog(getApplicationContext());
                dialog.setContentView(R.layout.custom_timeout_dialog);
                TextView textView=dialog.findViewById(R.id.timeout_dialog_text);
                textView.setText(correctCount+" - "+wrongCount);
                dialog.findViewById(R.id.timeout_dialog_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.show();*/

            }
        }.start();

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNext(questionList, --index);
            }
        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNext(questionList, ++index);
            }
        });


    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        builderBackAlert.setMessage("Do you want to go exit")
                .setCancelable(false)
                .setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        Intent intent = new Intent(getApplicationContext(), ShowResultActivity.class);
                        intent.putExtra("total", Integer.toString(total_question));
                        intent.putExtra("solved", Integer.toString(question_solved));
                        intent.putExtra("unsolved", Integer.toString(question_unsolved));
                        intent.putExtra("correct", Integer.toString(question_correct));
                        intent.putExtra("wrong", Integer.toString(question_wrong));

                        startActivity(intent);

                    }
                }).setNegativeButton("BACK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /////////nothing to do
            }
        });
        //Creating dialog box
        AlertDialog alert = builderBackAlert.create();
        //Setting the title manually
        alert.setTitle("Alert");
        alert.getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND, 1);
        alert.show();

     }



    private void callNext(List<Question> questionList, int i) {
        if (i < 0) {
            Toast.makeText(getApplicationContext(), "you have come to the start of question", Toast.LENGTH_LONG).show();

            return;
        } else if (i >= questionList.size()) {
            index--;
            builder.setMessage("you have come to the end of question")
                    .setCancelable(false)
                    .setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                            Intent intent = new Intent(getApplicationContext(), ShowResultActivity.class);
                            intent.putExtra("total", Integer.toString(total_question));
                            intent.putExtra("solved", Integer.toString(question_solved));
                            intent.putExtra("unsolved", Integer.toString(question_unsolved));
                            intent.putExtra("correct", Integer.toString(question_correct));
                            intent.putExtra("wrong", Integer.toString(question_wrong));

                            startActivity(intent);

                        }
                    }).setNegativeButton("BACK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    /////////nothing to do
                }
            });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle("Alert");
            alert.getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND, 1);
            alert.show();
            return;
        } else {
            switch (questionList.get(i).getType()) {
                case "MCQ":
                    MCQuserFragment fragment1 = new MCQuserFragment(questionList.get(i));
                    FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();

                    transaction1.replace(R.id.fragement_question, fragment1);
                    transaction1.commit();


                    break;
                case "IVA":
                    IVAuserFragment fragment2 = new IVAuserFragment(questionList.get(i));
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();

                    transaction2.replace(R.id.fragement_question, fragment2);
                    transaction2.commit();
                    break;
                case "SWA":
                    SWAuserFragment fragment3 = new SWAuserFragment(questionList.get(i));
                    FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();

                    transaction3.replace(R.id.fragement_question, fragment3);
                    transaction3.commit();
                    break;
                case "NAT":
                    NATuserFragment fragment4 = new NATuserFragment(questionList.get(i));
                    FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();

                    transaction4.replace(R.id.fragement_question, fragment4);
                    transaction4.commit();
                    break;
                default:
                    break;

            }
        }
    }


    void updateTopBar() {
        total_question_txt.setText(total_question + "");
        question_unsolved_txt.setText(question_unsolved + "");
        question_solved_txt.setText(question_solved + "");
        question_wrong_txt.setText(question_wrong + "");
        question_correct_txt.setText(question_correct + "");

    }

    /*shareIt((takeScreenshot()));/8*/


    private Bitmap screenShot(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

    private void share(Bitmap bitmap) {
        Log.w("asdf", "777");

        String pathofBmp =
                MediaStore.Images.Media.insertImage(getContentResolver(),
                        bitmap, "QuizApp_screenshot", "ccc");
        Uri uri = Uri.parse(pathofBmp);
        Log.w("asdf", "777" + pathofBmp);

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "QuizApp");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "try this question");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(shareIntent, "start"));


    }

}
























































/*

    void actionOnCorrect(){
        correctCount++;
        index++;
        current=(MCQ) questionList.get(index);
//        setText(current);

    }

    void actionOnWrong(){
        wrongCount++;
        index++;
        current=(MCQ) questionList.get(index);
//        setText(c/urrent);

    }



*/