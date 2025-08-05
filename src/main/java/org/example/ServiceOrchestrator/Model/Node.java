package org.example.ServiceOrchestrator.Model;

public class Node {
    String id;
    Integer weight;
    String ip;

    public Node(String id, Integer weight, String ip) {
        this.id = id;
        this.weight = weight;
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public Integer getWeight() {
        return weight;
    }
}
