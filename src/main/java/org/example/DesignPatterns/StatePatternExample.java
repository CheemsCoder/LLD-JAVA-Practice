package org.example.DesignPatterns;
/*
 * =============================
 * State Design Pattern in Java
 * =============================
 *
 * ➤ Intent:
 *    The State Pattern allows an object to change its behavior when its internal state changes.
 *    It appears as if the object has changed its class.
 *
 * ➤ Problem:
 *    An object should change its behavior when its state changes, but without using large if-else or switch-case blocks.
 *
 * ➤ Solution:
 *    - Create a "State" interface to define behavior for different states.
 *    - Implement concrete state classes for each state.
 *    - Use a Context class that maintains a reference to a State instance and delegates behavior to it.
 *
 * ➤ Real-world Examples:
 *    - Vending Machine (Idle, HasMoney, Dispensing)
 *    - Media Player (Playing, Paused, Stopped)
 *    - Fan (On, Off, Medium, High)
 *
 * ➤ Benefits:
 *    - Eliminates complex conditional logic.
 *    - Follows Open/Closed Principle (easy to add new states).
 *    - Enhances code readability and maintenance.
 */

public class StatePatternExample {

    // State interface
    interface State {
        void handle();
    }

    // Concrete State: On
    public static class OnState implements State {
        @Override
        public void handle() {
            System.out.println("Fan is ON");
        }
    }

    // Concrete State: Off
    public static class OffState implements State {
        @Override
        public void handle() {
            System.out.println("Fan is OFF");
        }
    }

    // Context class holding the current state
    public static class FanContext {
        private State currentState;

        public FanContext() {
            currentState = new OffState(); // Default state
        }

        public void setState(State state) {
            this.currentState = state;
        }

        public void request() {
            currentState.handle();
        }
    }

    // Client code
    public static void main(String[] args) {
        FanContext fan = new FanContext();

        fan.request(); // Output: Fan is OFF

        fan.setState(new OnState());
        fan.request(); // Output: Fan is ON

        fan.setState(new OffState());
        fan.request(); // Output: Fan is OFF
    }
}
