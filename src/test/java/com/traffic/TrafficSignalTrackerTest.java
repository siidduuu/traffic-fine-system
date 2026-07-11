package com.traffic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficSignalTrackerTest {

    private TrafficSignalTracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new TrafficSignalTracker();
    }

    @Test
    @DisplayName("Should issue a $500 fine when parked on a zebra crossing during a RED signal")
    void testViolationOnRedSignal() {
        double expectedFine = 500.00;
        double actualFine = tracker.checkViolationAndCalculateFine("RED", true);
        
        assertEquals(expectedFine, actualFine, "Vehicle parked on zebra crossing during RED light must be fined.");
    }

    @Test
    @DisplayName("Should issue NO fine when parked on a zebra crossing during a GREEN signal")
    void testNoViolationOnGreenSignal() {
        double expectedFine = 0.0;
        double actualFine = tracker.checkViolationAndCalculateFine("GREEN", true);
        
        assertEquals(expectedFine, actualFine, "Vehicles crossing or stopping during GREEN should not receive a zebra crossing fine.");
    }

    @Test
    @DisplayName("Should issue NO fine when clear of the zebra crossing during a RED signal")
    void testNoViolationWhenNotOnCrossing() {
        double expectedFine = 0.0;
        double actualFine = tracker.checkViolationAndCalculateFine("RED", false);
        
        assertEquals(expectedFine, actualFine, "Vehicles stopped behind the white line during RED should not be fined.");
    }

    @Test
    @DisplayName("Should be case-insensitive to the signal color input")
    void testCaseInsensitivityOfSignal() {
        double expectedFine = 500.00;
        double actualFine = tracker.checkViolationAndCalculateFine("red", true);
        
        assertEquals(expectedFine, actualFine, "The system should handle lowercase 'red' inputs cleanly.");
    }
}

