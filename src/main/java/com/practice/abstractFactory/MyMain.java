package com.practice.abstractFactory;

public class MyMain {
    public static void main(String[] args) {
        Manufacturer msiManufacturer = new MsiManufacturer();
        Gpu msiGpu = msiManufacturer.createGpu();
        msiGpu.assemble();
        Monitor msiMonitor = msiManufacturer.createMonitor();
        msiMonitor.assemble();

        Manufacturer asusManufacturer = new AsusManufacturer();
        Gpu asusGpu = asusManufacturer.createGpu();
        asusGpu.assemble();
        Monitor asusMonitor = asusManufacturer.createMonitor();
        asusMonitor.assemble();
    }
}
