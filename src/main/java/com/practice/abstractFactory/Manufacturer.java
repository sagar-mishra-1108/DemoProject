package com.practice.abstractFactory;

public abstract class Manufacturer {
    public Gpu assembleGpu() {
        Gpu gpu = createGpu();
        gpu.assemble();
        return gpu;
    }

    public abstract Gpu createGpu();
    public abstract Monitor createMonitor();
}
