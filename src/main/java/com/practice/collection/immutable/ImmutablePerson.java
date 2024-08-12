package com.practice.collection.immutable;

import java.util.ArrayList;
import java.util.List;

public final class ImmutablePerson {
    private final Integer id;
    private final String name;
    private final Address address;
    private final List<String> phoneNumbers;

    public ImmutablePerson(Integer id, String name, Address address, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }

    public List<String> getPhoneNumbers() {
        return new ArrayList<>(phoneNumbers);
    }
}
