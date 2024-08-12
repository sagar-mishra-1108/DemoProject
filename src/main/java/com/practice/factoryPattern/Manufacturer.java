package com.practice.factoryPattern;

public abstract class Manufacturer {
    public Gpu assembleGpu() {
        Gpu gpu = createGpu();
        gpu.assemble();
        return gpu;
    }

    public abstract Gpu createGpu();
}
