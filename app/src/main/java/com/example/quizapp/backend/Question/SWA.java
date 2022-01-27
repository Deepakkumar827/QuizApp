package com.example.quizapp.backend.Question;

//SWA- single word answer

import java.util.Locale;

public class SWA extends Question {
    static final String type="SWA";  ////may be final/static

    String subject;
    static int sWAidgenerator=0;
    int SWAid;
    String creator;
    String question;
    String answer;





    protected SWA(String creator, String subject, String question, String answer) {
        super();
        this.creator=creator;
        this.subject=subject;
        this.question=question;
        this.answer=answer.toLowerCase(Locale.ROOT).trim();
        this.SWAid=sWAidgenerator++;
        this.subject=subject;
        super.questionid=Question.idgenerator++;

    }


    @Override
    public String getType() {
        return type;
    }


    @Override
    public String getSubject() {
        return subject;
    }

    public int getSWAid() {
        return SWAid;
    }

    @Override
    public String getCreator() {
        return creator;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }




    public static final int getTotalSWAGenerated() {
        return sWAidgenerator;
    }


}
