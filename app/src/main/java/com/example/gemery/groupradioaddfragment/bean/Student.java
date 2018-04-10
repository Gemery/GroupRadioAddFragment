package com.example.gemery.groupradioaddfragment.bean;

/**
 * Created by gemery on 2018/4/9.
 */

public class Student {
    private String name;
    private String age;
    private int gender;
    private String school;
    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender=" + gender +
                ", school='" + school + '\'' +
                ", grade=" + grade +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {

        return name;
    }

    public String getAge() {
        return age;
    }

    public int getGender() {
        return gender;
    }

    public String getSchool() {
        return school;
    }

    public Student() {


    }
}
