package com.practice.parkingLot;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Vehicle {
    private String licensePlate;

    public abstract VehicleType getType();
}
