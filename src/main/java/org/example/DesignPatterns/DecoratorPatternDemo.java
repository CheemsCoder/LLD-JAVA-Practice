package org.example.DesignPatterns;

/*
    Decorator Design Pattern

    Purpose: Add new behavior to objects dynamically without altering their class.
    Use Case: Wrapping objects with additional functionality (e.g., adding milk/sugar to coffee).
*/

// Component interface
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete component
class BasicCoffee implements Coffee {
    public String getDescription() {
        return "Basic Coffee";
    }

    public double getCost() {
        return 5.0;
    }
}

// Decorator base class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

// Concrete decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    public double getCost() {
        return coffee.getCost() + 1.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    public double getCost() {
        return coffee.getCost() + 0.5;
    }
}

// Client code
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // Basic coffee
        Coffee coffee = new BasicCoffee();
        System.out.println(coffee.getDescription() + " = $" + coffee.getCost());

        // Add milk
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " = $" + coffee.getCost());

        // Add sugar
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " = $" + coffee.getCost());
    }
}

