package com.example.firstcognizantapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Student implements Parcelable {
    static String COLLEGE_NAME = "IU";
    String studentName;
    int studentAge;
    float stipend;

    public Student(String studentName, int studentAge, float stipend) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.stipend = stipend;
    }

    public Student(Parcel parcel){
        this.studentName = parcel.readString();
        this.studentAge = parcel.readInt();
        this.stipend = parcel.readFloat();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.studentName);
        parcel.writeInt(this.studentAge);
        parcel.writeFloat(this.stipend);
    }

    public String toString(){
        return "Student{ student name = " + this.studentName + ","
                + "student age = " + this.studentAge + ","
                + "student stipend = " + this.stipend + "}";
    }
}
