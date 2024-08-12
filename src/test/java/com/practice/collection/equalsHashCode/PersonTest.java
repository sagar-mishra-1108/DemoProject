package com.practice.collection.equalsHashCode;

import org.junit.jupiter.api.Test;
import com.practice.collection.equalsHashCode.Person;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testEquals() {
        Person sagar = new Person(101, "Sagar Mishra", LocalDate.of(1990, 8, 11));
        Person rahul = new Person(103, "Rahul Khan", LocalDate.of(1988, 4, 19));
        Person priya = new Person(107, "Priya Pareshan", LocalDate.of(1993, 11, 3));
        Person arnold = new Person(107, "Arnold Patel", LocalDate.of(1992, 3, 7));
        Person arnoldReturns = new Person(107, "Arnold Patel", LocalDate.of(1992, 3, 7));

        assertTrue(arnold.equals(arnoldReturns));
        assertTrue(arnold.hashCode() == arnoldReturns.hashCode());
        assertFalse(sagar.equals(null));
        assertFalse(sagar.equals(rahul));
        assertTrue(rahul.hashCode() != priya.hashCode());
    }
}