package org.example.LoadBalancer;

import java.util.LinkedHashSet;
import java.util.Set;

public class Service {
    String name;
    Set<Destination> destinations;

    public Service(String name, Set<Destination> destinations) {
        this.name = name;
        this.destinations = new LinkedHashSet<>(destinations);
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }
    public void removeDestination(Destination destination) {
        destinations.remove(destination);
    }
}
