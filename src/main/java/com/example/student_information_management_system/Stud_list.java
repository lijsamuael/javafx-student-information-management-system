package com.example.student_information_management_system;

public class Stud_list {
    private String id;
    private String f_name;
    private String l_name;
    private String sex;
    private String departement;
    private int batch;

    public Stud_list(String id, String f_name, String l_name, String sex, String departement, int batch) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.sex = sex;
        this.departement = departement;
        this.batch = batch;
    }

    public String getId() {
        return id;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getSex() {
        return sex;
    }

    public String getDepartement() {
        return departement;
    }

    public int getBatch() {
        return batch;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }
}
