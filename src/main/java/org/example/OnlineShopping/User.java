package org.example.OnlineShopping;

public class User {
    String name;
    Integer id;
    String email;

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.email = builder.email;
    }

    public static class UserBuilder {
        String name = "";
        Integer id;
        String email = "";

        public UserBuilder(Integer id) {
            this.id =id;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
}
