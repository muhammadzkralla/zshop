package com.zkrallah.zbooks.model.customer;

public class Customer {
    // I chose the name to be the UID of the user, so I made it final to be
    // immutable
    // Maybe this is not the best scalable approach but I'll keep it simple for now
    // as it's a toy project
    private final String name;
    private double balance;
    private String location;

    public Customer(final String name, final double balance, final String location) {
        this.name = name;
        this.balance = balance;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

}
