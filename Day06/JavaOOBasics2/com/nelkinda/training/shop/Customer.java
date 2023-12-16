package com.nelkinda.training.shop;

class Customer {
    private String id;
    private String firstname;
    private String lastname;
    private String getId() {
        return id;
    }
    String getName() {
        return firstname + " " + lastname;
    }
}
