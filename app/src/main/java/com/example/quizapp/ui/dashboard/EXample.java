package com.example.quizapp.ui.dashboard;

public class EXample {
    String first, born , title;

    public EXample(String first, String born, String title) {
        this.first = first;
        this.born = born;
        this.title = title;
    }
    public EXample(){

    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
