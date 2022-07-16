package com.example.student_information_management_system;

public class course {
    private String course;
    private String instructor;
    private int crhr;
    private int code;
    private int year;
    private int semister;
    private String grade;

    public course(String course, String instructor, int crhr, int code, int year, int semister, String grade) {
        this.course = course;
        this.instructor = instructor;
        this.crhr = crhr;
        this.code = code;
        this.year = year;
        this.semister = semister;
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getCrhr() {
        return crhr;
    }

    public int getCode() {
        return code;
    }

    public int getYear() {
        return year;
    }

    public int getSemister() {
        return semister;
    }

    public String getGrade() {
        return grade;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setCrhr(int crhr) {
        this.crhr = crhr;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSemister(int semister) {
        this.semister = semister;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

