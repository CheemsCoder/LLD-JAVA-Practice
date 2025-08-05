package org.example.LoadBalancer;

import java.util.Map;
import java.util.*;
import java.util.Queue;
import java.util.Set;

public class RoundRobinLoadBalancer extends LoadBalancer {
    Map<RequestType, Queue<Destination>> destinations;

    public RoundRobinLoadBalancer() {
        this.destinations = new HashMap<>();
    }
    @Override
    Destination balance(final Request request) {
        if(!destinations.containsKey(request.type)) {
            Set<Destination> destinationSet = getDestinations(request);
            Queue<Destination> queue = new LinkedList<>(new ArrayList<>(destinationSet));
            destinations.put(request.type, queue);
        }
        Destination destination = destinations.get(request.type).poll();
        destinations.get(request.type).add(destination);
        return destination;
    }
}
