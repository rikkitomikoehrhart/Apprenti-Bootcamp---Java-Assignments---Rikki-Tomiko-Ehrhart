package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GumballMachineTest {
    GumballMachine machine;

    @BeforeEach
    public void setUp() {
        machine = new GumballMachine(); // assures that each test has a known good starting state
    }

    @Test
    public void testWaitingForCoinHasCoinHandleTurns() {
        assertTrue(machine.insertCoin()); // Arrange
        assertEquals(GumballMachine.GumballState.WaitingForCoin, machine.getState()); // Verify starting state
        boolean handleTurned = machine.turnHandle(); // Act
        GumballMachine.GumballState actualState = machine.getState();

        assertTrue(handleTurned); // Assert

        assertEquals(GumballMachine.GumballState.ReadyToDispense, machine.getState()); // Verify final state
    }


    

}
