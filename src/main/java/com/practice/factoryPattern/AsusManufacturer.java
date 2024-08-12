package com.practice.factoryPattern;

public class AsusManufacturer extends Manufacturer {
    @Override
    public Gpu createGpu() {
        return new AsusGpu();
    }
}
