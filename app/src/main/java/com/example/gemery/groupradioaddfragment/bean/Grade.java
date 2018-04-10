package com.example.gemery.groupradioaddfragment.bean;

/**
 * Created by gemery on 2018/4/9.
 */

public class Grade {

    private String course;
    private String score;
    private String level;

    @Override
    public String toString() {
        return "Grade{" +
                "course='" + course + '\'' +
                ", score='" + score + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
