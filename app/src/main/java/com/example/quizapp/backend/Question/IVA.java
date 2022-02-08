package com.example.quizapp.backend.Question;



//// IVA integer value answer

import java.io.Serializable;

public class IVA extends Question implements Serializable {
    String type="IVA";  ////may be final/static
    String creator;




    String board="all";
    String standard="all";

    String prev="core";
    String subject;
    String chapter="all";
    String question;
    int answer;
    String message="currently unavailable";


    public IVA(String creator, String board, String standard, String prev, String subject, String chapter, String question, int answer, String message) {
        this.creator = creator;
        this.board=board;
        this.message = message;
        this.standard = standard;
        this.prev = prev;
        this.subject = subject;
        this.chapter = chapter;
        this.question = question;
        this.answer = answer;
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


    @Override
    public String getStandard() {
        return standard;
    }

    @Override
    public String getPrev() {
        return prev;
    }
    @Override
    public String getChapter() {
        return chapter;
    }

    @Override
    public String getBoard() {
        return board;
    }
}


