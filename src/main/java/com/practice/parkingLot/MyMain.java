package com.practice.parkingLot;

public class MyMain {
    public static void main(String[] args) {
        ParkingChargeCalculator parkingChargeCalculator = new SimpleParkingChargeCalculator();
        ParkingLot parkingLot = new ParkingLot(5, parkingChargeCalculator);

        Vehicle car1 = new Car("CAR123");
        Vehicle bike1 = new Bike("BIKE123");
        Vehicle truck1 = new Truck("TRUCK123");
        Vehicle car2 = new Car("CAR456");
        Vehicle bike2 = new Bike("BIKE456");
        Vehicle truck2 = new Truck("TRUCK456");

        boolean parked1 = parkingLot.parkVehicle(car1); // spot 1
        System.out.println(parked1 ? car1.getType() + "parked successfully in Spot 1" : "Unable to Park. No available space");
        boolean parked2 = parkingLot.parkVehicle(car2); // spot 2
        System.out.println(parked2 ? car2.getType() + "parked successfully in Spot 2" : "Unable to Park. No available space");
        boolean parked3 = parkingLot.parkVehicle(bike1); // spot 3
        System.out.println(parked3 ? bike1.getType() + "parked successfully in Spot 3" : "Unable to Park. No available space");
        boolean parked4 = parkingLot.parkVehicle(bike2); // spot 4
        System.out.println(parked4 ? bike2.getType() + "parked successfully in Spot 4" : "Unable to Park. No available space");
        boolean parked5 = parkingLot.parkVehicle(truck1); // spot 5
        System.out.println(parked5 ? truck1.getType() + "parked successfully in Spot 5" : "Unable to Park. No available space");
        boolean parked6 = parkingLot.parkVehicle(truck2); // unable to park
        System.out.println(parked6 ? truck2.getType() + "parked successfully in Spot 5" : "Unable to Park. No available space");

        System.out.println("Parking spots available: " + parkingLot.getFreeSpotsCount());

        boolean departed1 = parkingLot.depart(1, 3); // 20*3 = 60
        if (departed1) {
            System.out.println("Departed from Spot 1");
            System.out.println("Parking spots available: " + parkingLot.getFreeSpotsCount());
        }

        boolean departed2 = parkingLot.depart(3, 2); // 10*2 = 20
        if (departed2) {
            System.out.println("Departed from Spot 3");
            System.out.println("Parking spots available: " + parkingLot.getFreeSpotsCount());
        }

        boolean departed3 = parkingLot.depart(2, 4); // 20*4 = 80
        if (departed3) {
            System.out.println("Departed from Spot 2");
            System.out.println("Parking spots available: " + parkingLot.getFreeSpotsCount());
        }

        boolean departed4 = parkingLot.depart(5, 1); // 50*1 = 50
        if (departed4) {
            System.out.println("Departed from Spot 5");
            System.out.println("Parking spots available: " + parkingLot.getFreeSpotsCount());
        }

        boolean departed5 = parkingLot.depart(4, 5); // 10*5 = 50
        if (departed5) {
            System.out.println("Departed from Spot 4");
            System.out.println("Parking spots available: " + parkingLot.getFreeSpotsCount());
        }

        System.out.println("Total Income: " + parkingLot.getTotalIncome());
        System.out.println("Total Vehicles Parked : " + parkingLot.getTotalVehiclesParked());

        System.out.println("List of available spots: " + parkingLot.getFreeSpotsList());

        Vehicle truck3 = new Truck("TRUCK789");
        boolean parked7 = parkingLot.parkVehicle(truck3);
        System.out.println(parked7 ? truck3.getType() + "parked successfully in Spot 1" : "Unable to Park. No available space");

        System.out.println("Parking spots available: " + parkingLot.getFreeSpotsCount());
        System.out.println("List of available spots: " + parkingLot.getFreeSpotsList());

    }
}
