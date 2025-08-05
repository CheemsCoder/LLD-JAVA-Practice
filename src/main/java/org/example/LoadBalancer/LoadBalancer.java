package org.example.LoadBalancer;

import java.util.*;

public abstract class LoadBalancer {
    Map<RequestType, Service> serviceMap;

    LoadBalancer() {
        serviceMap = new HashMap<>();
    }

    public void register(RequestType requestType, Service service) {
        serviceMap.put(requestType, service);
    }

    Set<Destination> getDestinations(Request request) {
        Service service = serviceMap.get(request.type);
        return service.destinations;
    }

    abstract Destination balance(Request request);

}
