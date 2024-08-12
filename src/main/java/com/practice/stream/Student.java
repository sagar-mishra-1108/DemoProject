package com.practice.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    Integer id;
    String name;
    Integer marks;
    String subject;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", subject='" + subject + '\'' +
                '}';
    }
}
