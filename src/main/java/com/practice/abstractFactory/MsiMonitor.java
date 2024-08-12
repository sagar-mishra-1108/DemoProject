package com.practice.abstractFactory;

public class MsiMonitor implements Monitor {
    @Override
    public void assemble() {
        System.out.println("MSI monitor assembled");
    }
}
