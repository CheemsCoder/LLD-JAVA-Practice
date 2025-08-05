package org.example.LoadBalancer;

public class Destination {
    String ip;
    Integer requestsBeingProcessed;
    Integer threshold;

    public Destination(String ip, Integer threshold) {
        this.ip = ip;
        this.threshold = threshold;
        this.requestsBeingProcessed = 0;
    }

    public boolean canProcessRequest() {
        if (requestsBeingProcessed < threshold) {
            return true;
        }
        return false;
    }

    public boolean addRequest(Request request) {
        if(requestsBeingProcessed<threshold) {
            requestsBeingProcessed++;
            return true;
        }
        return false;
    }

    public void compeleteRequest() {
        requestsBeingProcessed--;
    }
}
