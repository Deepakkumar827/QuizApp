package com.example.quizapp.backend.Question;

public  class Question {

    /// TODO following field should be private.
    static final String type="question";  ////may be final/static
    String subject="none";
    static int idgenerator=0;
    int questionid;
    int test;

    String creator="NONE";
    protected Question(){

    }

    public String getType() {
        return type;
    }

    public int getQuestionid() {
        return questionid;
    }

    public static final int getTotalQuestionGenerated() {
        return idgenerator;
    }

    public String getCreator() {
        return creator;
    }

    public String getSubject() {
        return subject;
    }

    public static Question createIVA(String creator,String subject, String question, int answer){
        Question newquestion=new IVA(creator, subject, question, answer);
        return newquestion;
    }
    //    public static IVA getIVA(int id){
//        //TODO not implemented yet
//        return null;
//    }
    public static Question createSMCQ4(String creator, String subject, String question, String firstchoice, String secondchoice, String thirdchoice, String fourthchoice, int answer){

        Question newquestion=new SMCQ4(creator, subject, question,firstchoice, secondchoice, thirdchoice, firstchoice, answer);
        return newquestion;
    }

    public static Question createSWA(String creator,String subject, String question, String answer){
        Question q=new SWA(creator,subject, question, answer);
        return q;
    }

    public static Question createNVA(String creator,String subject, String question, float answer){
        Question newquestion=new NVA(creator, subject, question, answer);
        return newquestion;
    }








}
