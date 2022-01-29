package com.example.quizapp.backend.Question;

//SWA- single word answer

import java.io.Serializable;
import java.util.Locale;

public class SWA extends Question implements Serializable {
    static final String type="SWA";  ////may be final/static

    String message="currently unavailable";
    String subject;
    String creator;
    String question;
    String answer;





    protected SWA(String creator, String subject, String question, String answer, String message) {
        super();
        this.creator=creator;
        this.subject=subject;
        this.question=question;
        this.answer=answer.toLowerCase(Locale.ROOT).trim();
        this.subject=subject;
        this.message=message;

    }


    @Override
    public String getMessage() {
        return message;
    }


    @Override
    public String getType() {
        return type;
    }


    @Override
    public String getSubject() {
        return subject;
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






}
