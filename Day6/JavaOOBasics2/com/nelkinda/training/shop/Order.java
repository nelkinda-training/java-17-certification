package com.nelkinda.training.shop;

class Order {
    private String id;
    private Customer customer;
    private User seller;

    @Override
    public String toString() {
        return "Order ID " + id + " by " + customer.getName() + " from " + seller.getName();
    }
}
