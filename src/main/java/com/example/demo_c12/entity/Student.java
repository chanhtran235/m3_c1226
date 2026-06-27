package com.example.demo_c12.entity;

public class Student {
    private int id;
    private String name;
    private boolean gender;
    private int classId;


    public Student() {
    }

    public Student(int id, String name, boolean gender, int classId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.classId = classId;
    }

    public Student(String name, boolean gender, float score, int classId) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
