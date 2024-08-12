package com.practice.parkingLot;

public interface ParkingChargeCalculator {
    double calculateCharge(Vehicle vehicle, long durationInHours);
}
