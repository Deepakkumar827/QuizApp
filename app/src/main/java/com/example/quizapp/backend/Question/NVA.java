package com.example.quizapp.backend.Question;

public class NVA extends Question {
    static final String type="IVA";  ////may be final/static
    String subject;
    static int nVAidgenerator=0;
    int NVAid;
    String creator;
    String question;
    float answer;

    protected NVA(String creator, String subject, String question, float answer){
        super();
        this.creator=creator;
        this.subject=subject;
        this.question=question;
        this.answer=answer;
        NVAid=nVAidgenerator++;
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

    public static int getTotalNVAgenerated() {
        return nVAidgenerator;
    }

    public int getNVAid() {
        return NVAid;
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
