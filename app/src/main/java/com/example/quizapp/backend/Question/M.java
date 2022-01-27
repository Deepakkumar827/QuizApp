package com.example.quizapp.backend.Question;

import com.example.quizapp.backend.data.AllQuestion;

public class M {

    public static void m() {

        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");


        for(Question iva: AllQuestion.allQuestion){
            System.out.println("----------------------------");
            System.out.println(iva.getType());
            System.out.println(iva.getCreator());
//            System.out.println(iva.getIVAid());
            System.out.println(iva.getQuestionid());
//            System.out.println(iva.getQuestion());
//            System.out.println(iva.getAnswer());
        }
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        for(Question iva: AllQuestion.allQuestion){
            System.out.println("=========================================");

            System.out.println(((IVA)iva).getType());
            System.out.println(((IVA)iva).getCreator());
            System.out.println(((IVA)iva).getIVAid());
            System.out.println(((IVA)iva).getQuestionid());
            System.out.println(((IVA)iva).getQuestion());
            System.out.println(((IVA)iva).getAnswer());
        }
        System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
//        // write your code here
//        Question question1=Question.createIVA("deepak1","MAD", "21+2=?", 23);
//        Question question2=Question.createIVA("deepak2","MAD", "22+2=?", 24);
//        Question question3=Question.createIVA("deepak3","MAD", "23+2=?", 25);
//        Question question4=Question.createIVA("deepak4","MAD", "24+2=?", 26);
//        showvalue(question1);
//        showvalue(question2);
//        showvalue(question3);
//        showvalue(question4);
    }

    public static void showvalue(Question question){
        if(question.getType()=="IVA"){
            IVA iva= (IVA) question;
            System.out.println(iva.getType());
            System.out.println(iva.getCreator());
            System.out.println(iva.getIVAid());
            System.out.println(iva.getQuestionid());
            System.out.println(iva.getQuestion());
            System.out.println(iva.getAnswer());

            System.out.println("-----------------------------");

        }
    }
}

/*

<Button
        android:id="@+id/button"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="100dp"
                android:text="Button"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="@+id/nav_host_fragment_activity_main" />

<Button
        android:id="@+id/button2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Button"
                app:layout_constraintBottom_toTopOf="@+id/nav_view"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/button" />


 */