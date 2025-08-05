package org.example.ServiceOrchestrator.Model;

import org.example.ServiceOrchestrator.Algorithms.Router;

public class Service {
    private final Router router;
    private final String id;
    private final String[] methods;

    public Service(String id, Router router, String[] methods) {
        this.router = router;
        this.id = id;
        this.methods = methods;
    }

    public Router getRouter() {
        return router;
    }

    public String getId() {
        return id;
    }

    public String[] getMethods() {
        return methods;
    }
}
