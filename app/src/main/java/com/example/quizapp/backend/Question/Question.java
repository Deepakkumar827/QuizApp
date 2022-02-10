package com.example.quizapp.backend.Question;

import java.io.Serializable;

public   class Question implements Serializable {



    protected Question(){};


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

    public String getStandard() {
        return null;
    }


    public String getChapter() {
        return null;
    }

    public String getBoard() {
        return null;
    }



    public static Question createIVA(String creator, String board,  String standard,  String subject, String chapter, String question, int answer, String message){
        Question newquestion=new IVA(creator,board,standard, subject, chapter, question, answer, message);
        return newquestion;
    }

    public static Question createMCQ(String creator, String board, String standard, String subject,  String chapter, String question, String choice1, String choice2, String choice3, String choice4, int answer, String message){

        Question newquestion=new MCQ(creator,board, standard, subject, chapter, question, choice1, choice2, choice3,choice4,answer,message);
        return newquestion;
    }

    public static Question createSWA(String creator, String board, String standard, String subject, String chapter, String question, String answer, String message){
        Question q=new SWA(creator,board,standard, subject, chapter,question , answer,message);
        return q;
    }

    public static Question createNVA( String creator, String board, String standard, String subject,  String chapter, String question, float answer,float error, String message){
        Question newquestion=new NAT(creator, board,standard, subject,  chapter , question,answer,error,  message );
        return newquestion;
    }


}
