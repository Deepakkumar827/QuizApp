package com.example.quizapp.backend.Question;


///MMCQ4- multiple choice quesion with single answer with four choice

public class SMCQ4 extends Question {
    static final String type="SMCQ4";  ////may be final/static
    String subject;
    static int sMCQ4idgenerator=0;
    int SMCQ4id;
    String creator;
    String question;
    String choice1;
    String choice2;
    String choice3;
    String choice4;
    int answer;

    protected SMCQ4(String creator, String subject, String question, String choice1, String choice2, String choice3, String choice4, int answer){
        super();
        this.creator=creator;
        this.subject=subject;
        this.question=question;
        this.choice1=choice1;
        this.choice2=choice2;
        this.choice3=choice3;
        this.choice4=choice4;
        this.answer=answer;
        SMCQ4id=sMCQ4idgenerator++;
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

    public static int getSMCQ4generated() {
        return sMCQ4idgenerator;
    }

    public int getSMCQ4id() {
        return SMCQ4id;
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
}
