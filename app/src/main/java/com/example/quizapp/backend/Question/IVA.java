package com.example.quizapp.backend.Question;



//// IVA integer value answer

public class IVA extends Question {
    static final String type="IVA";  ////may be final/static
    String subject;
    static int iVAidgenerator=0;
    int IVAid;
    String creator;
    String question;
    int answer;

    protected IVA (String creator,String subject, String question, int answer){
        super();
        this.creator=creator;
        this.subject=subject;
        this.question=question;
        this.answer=answer;
        IVAid=iVAidgenerator++;
        super.questionid=Question.idgenerator++;
    }

    @Override
    public String getType() {
        return type;
    }
    public static final int getTotalIVAGenerated() {
        return iVAidgenerator;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    public int getIVAid() {
        return IVAid;
    }

    @Override
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
