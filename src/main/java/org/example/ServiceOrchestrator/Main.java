package org.example.ServiceOrchestrator;

import org.example.ServiceOrchestrator.Algorithms.ConsistentHashing;
import org.example.ServiceOrchestrator.Model.*;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Simple hash function
        Function<String, Long> hashFunction = key -> (long) Math.abs(key.hashCode());

        // Create load balancer
        LoadBalancer loadBalancer = new LoadBalancer();

        // Create router using consistent hashing with pointMultiplier = 3
        ConsistentHashing router = new ConsistentHashing(hashFunction, 3);

        // Create service
        Service userService = new Service("user-service", router, new String[]{"GET", "POST"});
        loadBalancer.register(userService);

        // Add nodes to service
        loadBalancer.addNode("user-service", new Node("node-1", 1, "10.0.0.1"));
        loadBalancer.addNode("user-service", new Node("node-2", 1, "10.0.0.2"));
        loadBalancer.addNode("user-service", new Node("node-3", 1, "10.0.0.3"));

        // Create requests
        for (int i = 1; i <= 10; i++) {
            Request request = new Request("req-" + i, "user-service", "GET");
            Node assignedNode = loadBalancer.getHandler(request);
            System.out.println("Request " + request.getId() + " routed to Node " +
                    (assignedNode != null ? assignedNode.getId() : "null"));
        }

        // Optionally remove a node
        loadBalancer.removeNode("user-service", "node-2");
        System.out.println("\nAfter removing node-2:\n");

        // Re-run requests to see redistribution
        for (int i = 1; i <= 10; i++) {
            Request request = new Request("req-" + i, "user-service", "GET");
            Node assignedNode = loadBalancer.getHandler(request);
            System.out.println("Request " + request.getId() + " routed to Node " +
                    (assignedNode != null ? assignedNode.getId() : "null"));
        }
    }
}
