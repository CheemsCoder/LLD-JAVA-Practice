package org.example.LoadBalancer;

import java.util.Set;

public class LeastConnectedLoadBalancer extends LoadBalancer {
    @Override
    Destination balance(final Request request) {
        Set<Destination> destinationSet = getDestinations(request);
        if(destinationSet.size() == 0) {
            System.out.println("Dont have any destinations");
            return null;
        }
        Destination destination = null;
        for(Destination d : destinationSet) {
            if(destination == null) {
                destination = d;
            } else {
                if(destination.requestsBeingProcessed > d.requestsBeingProcessed && d.canProcessRequest()) {
                    destination = d;
                }
            }
        }
        destination.addRequest(request);
        return destination;
    }
}
