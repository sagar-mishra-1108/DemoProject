package com.practice.factoryPattern;

public class MsiManufacturer extends Manufacturer {
    @Override
    public Gpu createGpu() {
        return new MsiGpu();
    }
}
