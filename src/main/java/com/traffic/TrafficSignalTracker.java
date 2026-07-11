package com.traffic;

public class TrafficSignalTracker {
    public static final double ZEBRA_CROSSING_FINE = 500.00;

    public double checkViolationAndCalculateFine(String signalColor, boolean isOnZebraCrossing) {
        // Violations only occur if stopped on a zebra crossing during a RED signal
        if ("RED".equalsIgnoreCase(signalColor) && isOnZebraCrossing) {
            return ZEBRA_CROSSING_FINE;
        }
        return 0.0;
    }
}

