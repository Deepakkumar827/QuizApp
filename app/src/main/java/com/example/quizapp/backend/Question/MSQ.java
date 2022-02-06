package com.example.quizapp.backend.Question;

///TODO pending

/// MSQ - multiple choice question with more than one answer with four choice

////

import java.io.Serializable;

public class MSQ implements Serializable {
    static final String type = "IVA";  ////may be final/static
    String subject;

    static int mMCQ4idgenerator = 0;
    int MMCQ4id;
    String creator;


}