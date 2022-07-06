package com.example.firstcognizantapp;

public class Student {
    String studentName;
    int studentAge;
    float stipend;

    public Student(String studentName, int studentAge, float stipend) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.stipend = stipend;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public float getStipend() {
        return stipend;
    }

    public void setStipend(float stipend) {
        this.stipend = stipend;
    }
}
