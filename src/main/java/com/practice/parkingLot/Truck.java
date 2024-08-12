package com.practice.parkingLot;

public class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
