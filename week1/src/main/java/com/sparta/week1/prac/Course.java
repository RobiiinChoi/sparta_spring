package com.sparta.week1.prac;

public class Course {
    private String tutor;
    private String title;
    private int days;


    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getTutor() {
        return this.tutor;
    }

    public String getTitle() {
        return this.title;
    }

    public int getDays() {
        return this.days;
    }
}
