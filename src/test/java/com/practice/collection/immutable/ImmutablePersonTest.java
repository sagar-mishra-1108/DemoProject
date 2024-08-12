package com.practice.collection.immutable;

import org.junit.jupiter.api.Test;
import com.practice.collection.immutable.Address;
import com.practice.collection.immutable.ImmutablePerson;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ImmutablePersonTest {

    @Test
    public void testImmutablePerson() throws CloneNotSupportedException {
        Address address = new Address("404 Ether Street", "Larnia", "H2 069");
        ImmutablePerson thomas = new ImmutablePerson(102, "Thomas Cook", address, Arrays.asList("09876546969", "08765439696"));

        assertEquals(102, thomas.getId());
        assertEquals("Thomas Cook", thomas.getName());
        assertEquals("Larnia", thomas.getAddress().getCity());
        assertEquals(Arrays.asList("09876546969", "08765439696"), thomas.getPhoneNumbers());

        // Modifications
        thomas.getAddress().setCity("Wonderland");
        thomas.getPhoneNumbers().add("08001212121");

        assertEquals("Larnia", thomas.getAddress().getCity());
        assertFalse(thomas.getPhoneNumbers().contains("08001212121"));
        assertEquals(Arrays.asList("09876546969", "08765439696"), thomas.getPhoneNumbers());


    }
}