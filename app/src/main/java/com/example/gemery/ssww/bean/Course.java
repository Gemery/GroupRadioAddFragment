package com.example.gemery.ssww.bean;

/**
 * Created by gemery on 2018/4/9.
 */

public class Course {
    private String course;
    private String score;
    private String level;

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

    @Override
    public String toString() {
        return "Course{" +
                "course='" + course + '\'' +
                ", score='" + score + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
