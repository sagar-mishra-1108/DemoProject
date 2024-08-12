package com.practice.parkingLot;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParkingLot {
    private List<ParkingSpot> parkingSpots;
    private ParkingChargeCalculator chargeCalculator;
    @Getter
    private double totalIncome;
    @Getter
    private int totalVehiclesParked;

    public ParkingLot(int numberOfSpots, ParkingChargeCalculator chargeCalculator) {
        this.parkingSpots = new ArrayList<>();
        // initialize parking lot
        IntStream.rangeClosed(1, numberOfSpots).forEach(i -> parkingSpots.add(new ParkingSpot(i)));
        this.chargeCalculator = chargeCalculator;
        this.totalIncome = 0.0;
        this.totalVehiclesParked = 0;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot: parkingSpots) {
            if (spot.isFree()) {
                spot.parkVehicle(vehicle);
                totalVehiclesParked++;
                return true;
            }
        }
        return false;
    }

    public boolean depart(int spotNumber, long durationInHours) {
        if (spotNumber <= 0 || spotNumber > parkingSpots.size()) {
            return false;
        }

        ParkingSpot spot = parkingSpots.get(spotNumber - 1);

        if (!spot.isFree()) {
            double charge = chargeCalculator.calculateCharge(spot.getParkedVehicle(), durationInHours);
            totalIncome += charge;
            spot.depart();
            return true;
        }
        return false;
    }

    public int getFreeSpotsCount() {
        return (int) parkingSpots.stream().filter(ParkingSpot::isFree).count();
    }

    public List<Integer> getFreeSpotsList() {
        return parkingSpots.stream().filter(ParkingSpot::isFree).map(ParkingSpot::getSpotNumber).collect(Collectors.toList());
    }

}
