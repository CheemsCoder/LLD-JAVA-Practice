package org.example.LoadBalancer;

public class Request {
    String id;
    RequestType type;
    public Request(String id, RequestType type) {
        this.id = id;
        this.type = type;
    }
}
