package com.example.quizapp.backend.Question;

import java.io.Serializable;

public class NAT extends Question implements Serializable {
     String type="NAT";  ////may be final/static
    String creator;
    String message="currently unavailable";
    String board="all";
    String standard="all";
    String subject;
    String prev="core";
    String chapter="all";
    String question;
    float answer;
    float error;

    protected NAT(){}

    public NAT(String creator, String board, String standard, String subject, String prev, String chapter, String question, float answer, float error, String message) {
        this.creator = creator;
        this.message = message;
        this.board=board;
        this.standard = standard;
        this.subject = subject;
        this.prev = prev;

        this.chapter = chapter;
        this.question = question;
        this.answer = answer;
        this.error = error;
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

    public float getAnswer() {
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


    public float getError() {
        return error;
    }
}
