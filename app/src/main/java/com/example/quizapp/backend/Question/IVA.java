package com.example.quizapp.backend.Question;



//// IVA integer value answer

import java.io.Serializable;

public class IVA extends Question implements Serializable {
    static final String type="IVA";  ////may be final/static
    String message="currently unavailable";
    String subject;
    String creator;
    String question;
    int answer;

    protected IVA (String creator,String subject, String question, int answer, String message){
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
    public String getType() {
        return type;
    }


    public String getSubject() {
        return subject;
    }


    public String getCreator() {
        return creator;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }


}
