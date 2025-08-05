package org.example.DesignPatterns;

/*
    Chain of Responsibility Design Pattern

    Purpose: Pass a request along a chain of handlers. Each handler decides whether to process the request or pass it to the next.
    Use Case: Multi-level approval systems (e.g., purchase requests).
*/

// Handler interface
interface Approver {
    void setNextApprover(Approver approver);
    void approveRequest(PurchaseRequest request);
}

// Concrete handler classes
class Manager implements Approver {
    private Approver nextApprover;

    public void setNextApprover(Approver approver) {
        this.nextApprover = approver;
    }

    public void approveRequest(PurchaseRequest request) {
        if (request.getAmount() <= 1000) {
            System.out.println("Manager approved request of $" + request.getAmount());
        } else if (nextApprover != null) {
            nextApprover.approveRequest(request);
        }
    }
}

class Director implements Approver {
    private Approver nextApprover;

    public void setNextApprover(Approver approver) {
        this.nextApprover = approver;
    }

    public void approveRequest(PurchaseRequest request) {
        if (request.getAmount() <= 5000) {
            System.out.println("Director approved request of $" + request.getAmount());
        } else if (nextApprover != null) {
            nextApprover.approveRequest(request);
        }
    }
}

class CEO implements Approver {
    public void setNextApprover(Approver approver) {
        // No further approvers, CEO is the last in the chain.
    }

    public void approveRequest(PurchaseRequest request) {
        System.out.println("CEO approved request of $" + request.getAmount());
    }
}

// Request object
class PurchaseRequest {
    private double amount;

    public PurchaseRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

// Client
public class ChainOfResponsibilityPatternDemo {
    public static void main(String[] args) {
        Approver manager = new Manager();
        Approver director = new Director();
        Approver ceo = new CEO();

        // Setting up the chain of responsibility
        manager.setNextApprover(director);
        director.setNextApprover(ceo);

        // Creating different purchase requests
        PurchaseRequest request1 = new PurchaseRequest(500);
        PurchaseRequest request2 = new PurchaseRequest(2000);
        PurchaseRequest request3 = new PurchaseRequest(7000);

        manager.approveRequest(request1); // Manager approved
        manager.approveRequest(request2); // Director approved
        manager.approveRequest(request3); // CEO approved
    }
}
