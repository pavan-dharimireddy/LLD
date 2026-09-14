package com.lld.behavioralpatterns.strategy.vehicledrivemodes.problem;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Vehicle Drive Modes: Problem Demo");

        // Base vehicle - normal drive mode
        Vehicle vehicle = new Vehicle();
        vehicle.drive();

        // Sports vehicle - sports drive mode
        vehicle = new SportsVehicle();
        vehicle.drive();

        // Off-road vehicle - off-road drive mode
        vehicle = new OffRoadVehicle();
        vehicle.drive();

        // Passenger vehicle - normal drive mode
        vehicle = new PassengerVehicle();
        vehicle.drive();
    }
}
