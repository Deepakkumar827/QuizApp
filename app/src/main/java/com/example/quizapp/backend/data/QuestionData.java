package com.example.quizapp.backend.data;

import com.example.quizapp.backend.Question.Question;

import java.util.ArrayList;

public class QuestionData {
    public static ArrayList<Question> mAD_SMCQ=new ArrayList<>();
    public static void setAll(){
       QuestionData.setmAD_SMCQ();


    }


    public static void setmAD_SMCQ(){
        mAD_SMCQ.add(Question.createMCQ("Deepak","Root","BTech CSE" ,"Mobile Application Development","Mixed" ,"Android is -", "an operating system", "a web browser", "a web server", "None of the above", 1, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","Root","BTech CSE" ,"Mobile Application Development","Mixed" , "Under which of the following Android is licensed?", "OSS", "Sourceforge", "Apache/MIT", "None of the above", 3, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","Root","BTech CSE" ,"Mobile Application Development","Mixed" ,"For which of the following Android is mainly developed?", "Servers", "Desktops", "Laptops", "Mobile devices", 4, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","Root","BTech CSE" ,"Mobile Application Development","Mixed" ,"Which of the following is the first mobile phone released that ran the Android OS?", "HTC Hero", "Google gPhone", "T - Mobile G1", "None of the above", 3, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","Root","BTech CSE" ,"Mobile Application Development","Mixed" , "Which of the following virtual machine is used by the Android operating system?", "JVM", "Dalvik virtual machine", "Simple virtual machine", "None of the above", 2, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","Root","BTech CSE" ,"Mobile Application Development","Mixed" , "Android is based on which of the following language?", "Java", "C++", "C", "None of the above", 1, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","Root","BTech CSE" ,"Mobile Application Development","Mixed" , "APK stands for -", "Android Phone Kit", "Android Page Kit", "Android Package Kit", "None of the above", 3, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","Root","BTech CSE" ,"Mobile Application Development","Mixed" , "What does API stand for?", "Application Programming Interface", "Android Programming Interface", "Android Page Interface", "Application Page Interface", 1, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","Root","BTech CSE" ,"Mobile Application Development","Mixed" , "Which of the following converts Java byte code into Dalvik byte code?", "Dalvik converter", "Dex compiler", "Mobile interpretive compiler (MIC)", "None of the above", 2, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","Root","BTech CSE" ,"Mobile Application Development","Mixed" , "How can we stop the services in android?", "By using the stopSelf() and stopService() method", "By using the finish() method", "By using system.exit() method", "None of the above", 1, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","Root","BTech CSE" ,"Mobile Application Development","Mixed" , "What is an activity in android?", "android class", "android package", "A single screen in an application with supporting java code", "None of the above", 3, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","Root","BTech CSE" ,"Mobile Application Development","Mixed" , "How can we kill an activity in android?", "Using finish() method", "Using finishActivity(int requestCode)", "Both (a) and (b)", "Neither (a) nor (b)", 3, "none"));
        mAD_SMCQ.add(Question.createMCQ("Deepak","Root","BTech CSE" ,"Mobile Application Development","Mixed" , "ADB stands for -", "Android debug bridge", "Android delete bridge", "Android destroy bridge", "None of the above", 1, "none"));
    }



/*


    head=new Trie("head");
        head.child.add(new Trie("all"));
        head.child.get(0).child.add(new Trie("10"));
        head.child.get(0).child.add(new Trie("11"));
        head.child.get(0).child.add(new Trie("12"));
        head.child.get(0).child.add(new Trie("BTech CSE"));
        head.child.get(0).child.add(new Trie("BTech Mechanical"));
        head.child.get(0).child.add(new Trie("BTech ECE"));
        head.child.get(0).child.add(new Trie("BTech Civil"));

*/




/*
    public static void setmAD_SMCQ(){
         mAD_SMCQ.add(Question.createMCQ("creater","root","standard" ,"subject","mixed" ,"Android", "choice1", "choice2", "choice3", "choice4", 1, "message"));
        mAD_SMCQ.add(Question.createMCQ("creater","root","standard" ,"subject","mixed" ,"Android", "choice1", "choice2", "choice3", "choice4", 1, "message"));
        mAD_SMCQ.add(Question.createMCQ("creater","root","standard" ,"subject","mixed" ,"Android", "choice1", "choice2", "choice3", "choice4", 1, "message"));
        mAD_SMCQ.add(Question.createMCQ("creater","root","standard" ,"subject","mixed" ,"Android", "choice1", "choice2", "choice3", "choice4", 1, "message"));
    }*/











}
