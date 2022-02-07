package com.example.quizapp.backend.data;

import com.example.quizapp.backend.Question.Question;

import java.util.ArrayList;

public class QuestionData {
    public static ArrayList<Question> mAD_SMCQ=new ArrayList<>();
    public static void setAll(){
       QuestionData.setmAD_SMCQ();


    }
    public static void setmAD_SMCQ(){
        mAD_SMCQ.add(Question.createMCQ("Deepak","MAD", "Android is -", "an operating system", "a web browser", "a web server", "None of the above", 1, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","MAD", "Under which of the following Android is licensed?", "OSS", "Sourceforge", "Apache/MIT", "None of the above", 3, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","MAD", "For which of the following Android is mainly developed?", "Servers", "Desktops", "Laptops", "Mobile devices", 4, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","MAD", "Which of the following is the first mobile phone released that ran the Android OS?", "HTC Hero", "Google gPhone", "T - Mobile G1", "None of the above", 3, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","MAD", "Which of the following virtual machine is used by the Android operating system?", "JVM", "Dalvik virtual machine", "Simple virtual machine", "None of the above", 2, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","MAD", "Android is based on which of the following language?", "Java", "C++", "C", "None of the above", 1, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","MAD", "APK stands for -", "Android Phone Kit", "Android Page Kit", "Android Package Kit", "None of the above", 3, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","MAD", "What does API stand for?", "Application Programming Interface", "Android Programming Interface", "Android Page Interface", "Application Page Interface", 1, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","MAD", "Which of the following converts Java byte code into Dalvik byte code?", "Dalvik converter", "Dex compiler", "Mobile interpretive compiler (MIC)", "None of the above", 2, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","MAD", "How can we stop the services in android?", "By using the stopSelf() and stopService() method", "By using the finish() method", "By using system.exit() method", "None of the above", 1, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","MAD", "What is an activity in android?", "android class", "android package", "A single screen in an application with supporting java code", "None of the above", 3, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","MAD", "How can we kill an activity in android?", "Using finish() method", "Using finishActivity(int requestCode)", "Both (a) and (b)", "Neither (a) nor (b)", 3, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","MAD", "ADB stands for -", "Android debug bridge", "Android delete bridge", "Android destroy bridge", "None of the above", 1, "none"));

    }

}
