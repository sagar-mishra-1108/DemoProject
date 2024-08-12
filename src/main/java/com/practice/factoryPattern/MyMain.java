package com.practice.factoryPattern;

public class MyMain {
    public static void main(String[] args) {
        Manufacturer msiManufacturer = new MsiManufacturer();
        Gpu msiGpu = msiManufacturer.createGpu();
        msiGpu.assemble();
        Manufacturer asusManufacturer = new AsusManufacturer();
        Gpu asusGpu = asusManufacturer.createGpu();
        asusGpu.assemble();
    }
}
