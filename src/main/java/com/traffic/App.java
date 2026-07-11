package com.traffic;

public class App {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java -jar app.jar <VehicleID> <SignalColor> <IsOnZebraCrossing>");
            System.exit(1);
        }
        String vehicleId = args[0];
        String signalColor = args[1];
        boolean isOnZebraCrossing = Boolean.parseBoolean(args[2]);

        TrafficSignalTracker tracker = new TrafficSignalTracker();
        double fine = tracker.checkViolationAndCalculateFine(signalColor, isOnZebraCrossing);

        System.out.println("--- Traffic Check Result ---");
        System.out.println("Vehicle ID: " + vehicleId);
        if (fine > 0) {
            System.out.println("Status: VIOLATION DETECTED! Fine: $" + fine);
        } else {
            System.out.println("Status: No Violation.");
        }
    }
}

