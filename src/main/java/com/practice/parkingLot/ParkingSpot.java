package com.practice.parkingLot;

import lombok.Getter;

@Getter
public class ParkingSpot {
    private int spotNumber;
    private boolean isFree;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isFree = true;
        this.parkedVehicle = null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isFree = false;
    }

    public void depart() {
        this.parkedVehicle = null;
        this.isFree = true;
    }
}
