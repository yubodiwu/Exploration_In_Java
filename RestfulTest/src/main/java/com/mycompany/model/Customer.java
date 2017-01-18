package com.mycompany.model;

/**
 * Created by yubodiwu on 1/11/17.
 */
public class Customer {
    private Long id;
    String name;

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer() {
        // dummy constructor
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, Name='%s']", id, name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
