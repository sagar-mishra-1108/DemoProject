package com.practice.collection.equalsHashCode;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
public class Person implements Comparable<Person> {
    private Integer id;
    private String name;
    private LocalDate dob;

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        Person person = (Person) other;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(dob, person.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dob);
    }

    @Override
    public int compareTo(Person other) {
        return this.id - other.id;
    }
}
