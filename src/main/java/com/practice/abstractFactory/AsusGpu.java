package com.practice.abstractFactory;

public class AsusGpu implements Gpu {
    @Override
    public void assemble() {
        System.out.println("Asus GPU assembled");
    }
}
