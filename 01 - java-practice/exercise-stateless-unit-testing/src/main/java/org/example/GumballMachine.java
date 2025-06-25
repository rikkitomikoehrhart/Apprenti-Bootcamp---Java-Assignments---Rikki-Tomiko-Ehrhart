package org.example;

public class GumballMachine {
    public enum GumballState {
        WaitingForCoin,
        ReadyToDispense
    }

    private GumballState state = GumballState.WaitingForCoin;
    private boolean hasCoin = false;

    public GumballState getState() {
        return state;
    }

    public boolean insertCoin() {
        if (!hasCoin && state == GumballState.WaitingForCoin) {
            // Can only successfully insert a coin when there isn't a coin currently in the machine
            // and the machine is waiting for a coin
            hasCoin = true;
            return true;
        }
        return false;
    }

    public boolean turnHandle() {
        switch(state) {
            case WaitingForCoin:
                if (hasCoin) {
                    hasCoin = false; // accept the coin;
                    state = GumballState.ReadyToDispense;
                    return true;
                } else {
                    return false;  // No coin, handle doesn't turn
                }
            case ReadyToDispense:
                state = GumballState.WaitingForCoin;  // Reset to waiting for coin mode
                return true; // Dispense the gumball
        }
        return false;
    }


}
