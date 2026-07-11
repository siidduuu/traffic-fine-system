package com.traffic;

public class TrafficSignalTracker {
    public double checkViolationAndCalculateFine(String signalColor, boolean isOnZebraCrossing) {
        if ("RED".equalsIgnoreCase(signalColor) && isOnZebraCrossing) {
            return 500.00;
        }
        return 0.0;
    }
}

