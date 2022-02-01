package com.example.quizapp.backend.Question;

import java.io.Serializable;

public   class Question implements Serializable {



    public   String getMessage(){
        return null;
    }
    public   String getType(){
        return null;
    }

    public   String getCreator(){
        return null;
    }

    public   String getSubject(){

        return null;
    }

    public static Question createIVA(String creator,String subject, String question, int answer, String message){
        Question newquestion=new IVA(creator, subject, question, answer, message);
        return newquestion;
    }

    public static Question createSMCQ4(String creator, String subject, String question, String firstchoice, String secondchoice, String thirdchoice, String fourthchoice, int answer, String message){

        Question newquestion=new SMCQ4(creator, subject, question,firstchoice, secondchoice, thirdchoice, firstchoice, answer, message);
        return newquestion;
    }

    public static Question createSWA(String creator,String subject, String question, String answer, String message){
        Question q=new SWA(creator,subject, question, answer, message);
        return q;
    }

    public static Question createNVA(String creator,String subject, String question, float answer, String message){
        Question newquestion=new NVA(creator, subject, question, answer, message);
        return newquestion;
    }


}
