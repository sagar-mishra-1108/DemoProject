package com.collection.practice.immutable;

public final class Address implements Cloneable {
    private String firstLine;
    private String city;
    private String postcode;

    public Address(String firstLine, String city, String postcode) {
        this.firstLine = firstLine;
        this.city = city;
        this.postcode = postcode;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Address{" +
                "firstLine='" + firstLine + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
