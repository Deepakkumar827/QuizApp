package com.example.quizapp.backend.Question;

//SWA- single word answer

import java.io.Serializable;
import java.util.Locale;

public class SWA extends Question implements Serializable {
    String type="SWA";  ////may be final/static
    String creator;

    String message="currently unavailable";
    String board="all";
    String standard="all";
    String subject;
    String prev="core";
    String chapter="all";
    String question;
    String answer;



    protected SWA(){}


    public SWA(String creator, String board,  String standard, String subject, String prev, String chapter, String question, String answer, String message) {
        this.creator = creator;
        this.message = message;
        this.board=board;
        this.standard = standard;
        this.subject = subject;
        this.prev = prev;
        this.chapter = chapter;
        this.question = question;
        this.answer = answer;
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
