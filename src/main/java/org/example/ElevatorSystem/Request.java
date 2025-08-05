package org.example.ElevatorSystem;

public class Request {
    Integer source;
    Integer destination;

    public Request( Integer source, Integer destination) {
        this.source = source;
        this.destination = destination;
    }

    public char getDirection() {
        if(source != destination) {
            if(source > destination) {
                return 'D';
            } else {
                return 'U';
            }
        }
        return 'I';
    }

}
