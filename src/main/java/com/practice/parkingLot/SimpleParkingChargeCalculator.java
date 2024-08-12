package com.practice.parkingLot;

public class SimpleParkingChargeCalculator implements ParkingChargeCalculator {
    private static final double CAR_RATE = 20.0;
    private static final double BIKE_RATE = 10.0;
    private static final double TRUCK_RATE = 50.0;

    @Override
    public double calculateCharge(Vehicle vehicle, long durationInHours) {
        return switch (vehicle.getType()) {
            case CAR -> CAR_RATE * durationInHours;
            case BIKE -> BIKE_RATE * durationInHours;
            case TRUCK -> TRUCK_RATE * durationInHours;
        };
    }
}
