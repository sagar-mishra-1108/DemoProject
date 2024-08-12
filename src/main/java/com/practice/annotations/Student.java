package com.practice.annotations;

@XMLSerializable(tag = "Student")
public class Student {
    @XMLElement
    private int id;

    @XMLElement
    private String name;

    @XMLElement
    private int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
