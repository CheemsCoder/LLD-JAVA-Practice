package org.example.ResturantManagement;

import java.util.UUID;

public class MenuItem {
    String id;
    String name;
    Double price;
    Boolean active;
    public MenuItem(String name, Double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.active = true;
    }

    public Boolean isAvailable(){
        return active;
    }

    public void setActive(Boolean active){
        this.active = active;
    }
}
