package com.example.gemery.groupradioaddfragment.bean;

import java.util.List;

/**
 * Created by gemery on 2018/4/9.
 */

public class StudentA {
    private String name;
    private String age;
    private int gender;
    private String school;
    private List<Course> grade;

    public List<Course> getGrade() {
        return grade;
    }

    public StudentA() {

    }

    public void setGrade(List<Course> grade) {
        this.grade = grade;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "StudentA{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender=" + gender +
                ", school='" + school + '\'' +
                ", grade=" + grade +
                '}';
    }
}

