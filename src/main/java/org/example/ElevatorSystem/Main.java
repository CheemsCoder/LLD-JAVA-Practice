package org.example.ElevatorSystem;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LiftManager manager = new LiftManager(3); // 3 lifts in the system

        // Simulate lift requests
        System.out.println("Sending Requests...");
        manager.requestLift(0, 5); // Lift should go from floor 0 to 5
        manager.requestLift(3, 0); // Lift should go from floor 3 to 0
        manager.requestLift(2, 7); // Another lift should serve this

        System.out.println("\nStarting Simulation...\n");

        // Simulate time progression
        for (int i = 0; i < 15; i++) {
            System.out.println("Tick " + i);
            manager.tick();

            // Print state of all lifts
            String[] states = manager.getLiftStates();
            for (int j = 0; j < states.length; j++) {
                System.out.println("Lift " + j + ": " + states[j]);
            }

            System.out.println();
            Thread.sleep(1000); // simulate 1-second interval
        }

        System.out.println("Simulation Complete.");
    }
}
