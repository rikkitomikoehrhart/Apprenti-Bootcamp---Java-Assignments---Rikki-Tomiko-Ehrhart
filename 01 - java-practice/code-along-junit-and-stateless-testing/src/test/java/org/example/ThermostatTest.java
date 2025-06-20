package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ThermostatTest {
    private Thermostat testThermostat;

    @BeforeEach
    void setUp() {
        testThermostat = new Thermostat();
        testThermostat.setTargetTemperature(72);
        testThermostat.setTolerance(2);
    }


    @Test
    public void thermostatStateShouldBeOnHeatWhenTempIsLow() {
        // ARRANGE:
        //      set sample readings that average below tolerance
        int[] tempInput = {72, 70, 68, 69, 70};
        Thermostat.ThermostatBehavior expectedResult = Thermostat.ThermostatBehavior.ON_HEAT;

        // ACT:
        //      get the actual result from the readSensorData method
        Thermostat.ThermostatBehavior actualResult = testThermostat.readSensorData(tempInput);
        
        // ASSERT:
        //
        assertEquals(expectedResult, actualResult);
    }
}
