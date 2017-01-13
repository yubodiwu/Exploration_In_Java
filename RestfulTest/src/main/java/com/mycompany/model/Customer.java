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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
