package com.example.quizapp.backend.Question;

import java.io.Serializable;

public class NVA extends Question implements Serializable {
     String type="IVA";  ////may be final/static
    String message="currently unavailable";

    String subject;
    String creator;
    String question;
    float answer;

    protected NVA(String creator, String subject, String question, float answer, String message){
        super();
        this.creator=creator;
        this.subject=subject;
        this.question=question;
        this.answer=answer;
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

    public double getAnswer() {
        return answer;
    }
}
