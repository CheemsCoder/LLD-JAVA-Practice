package org.example.DesignPatterns;

/*
    Builder Design Pattern

    Purpose: To construct complex objects using a step-by-step approach.
    Use Case: When there are many optional fields, and constructors become hard to manage.
*/

class User {
    private final String firstName;
    private final String lastName;
    // Optional parameters
    private final int age;
    private final String phone;
    private final String address;
    // Private constructor
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }
    public String toString() {
        return "Customer: " + firstName + " " + lastName +
                ", Age: " + age +
                ", Phone: " + phone +
                ", Address: " + address;
    }
    // Builder Class
    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;
        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
}

public class BuilderPatternDemo {
    public static void main(String[] args) {
        // Only required fields
        User user1 = new User.UserBuilder("John", "Doe").build();

        // All fields
        User user2 = new User.UserBuilder("Jane", "Smith")
                .age(30)
                .phone("1234567890")
                .address("123 Main St")
                .build();

        System.out.println(user1);
        System.out.println(user2);
    }
}

