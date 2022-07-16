package com.example.student_information_management_system;

public class Grade {
    private String course;
    private int s_15_1;
    private int s_15_2;
    private int s_20;
    private int s_50;
    private int S_100;
    private String Letter;

    public Grade(String course, int s_15_1, int s_15_2, int s_20, int s_50, int s_100, String letter) {
        this.course = course;
        this.s_15_1 = s_15_1;
        this.s_15_2 = s_15_2;
        this.s_20 = s_20;
        this.s_50 = s_50;
        S_100 = s_100;
        Letter = letter;
    }

    public String getCourse() {
        return course;
    }

    public int getS_15_1() {
        return s_15_1;
    }

    public int getS_15_2() {
        return s_15_2;
    }

    public int getS_20() {
        return s_20;
    }

    public int getS_50() {
        return s_50;
    }

    public int getS_100() {
        return S_100;
    }

    public String getLetter() {
        return Letter;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setS_15_1(int s_15_1) {
        this.s_15_1 = s_15_1;
    }

    public void setS_15_2(int s_15_2) {
        this.s_15_2 = s_15_2;
    }

    public void setS_20(int s_20) {
        this.s_20 = s_20;
    }

    public void setS_50(int s_50) {
        this.s_50 = s_50;
    }

    public void setS_100(int s_100) {
        S_100 = s_100;
    }

    public void setLetter(String letter) {
        Letter = letter;
    }
}
