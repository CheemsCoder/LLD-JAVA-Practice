package org.example.ServiceOrchestrator.Algorithms;

import org.example.ServiceOrchestrator.Model.*;

public interface Router {
    void addNode(Node node);
    void removeNode(Node node);
    Node getAssignedNode(Request request);

}
