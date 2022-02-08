package com.example.quizapp.backend.Question;


///MCQ- multiple choice quesion with single answer with four choice

import java.io.Serializable;

public class MCQ extends Question implements Serializable {
    String type="MCQ";  ////may be final/static
    String creator;
    String board="all";
    String standard="all";
    String subject;
    String prev="core";
    String chapter="all";

    String question;
    String choice1;
    String choice2;
    String choice3;
    String choice4;
    int answer;
    String message="currently unavailable";


    protected MCQ(){}

    public MCQ(String creator, String board,String standard, String subject, String prev, String chapter, String question, String choice1, String choice2, String choice3, String choice4, int answer, String message) {
        this.creator = creator;
        this.board=board;
        this.standard = standard;
        this.subject = subject;
        this.prev = prev;
        this.chapter = chapter;
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.answer = answer;
        this.message = message;
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

    public String getChoice1() {
        return choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public String getChoice4() {
        return choice4;
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
