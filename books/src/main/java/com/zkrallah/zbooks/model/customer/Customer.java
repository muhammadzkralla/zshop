package com.zkrallah.zbooks.model.customer;

public class Customer {
    // I chose the name to be the UID of the user, so I made it final to be
    // immutable
    // Maybe this is not the best scalable approach but I'll keep it simple for now
    // as it's a toy project
    private final String name;
    private double balance;
    private final String location;
    private final String email;

    public Customer(final String name, final double balance, final String location, final String email) {
        this.name = name;
        this.balance = balance;
        this.location = location;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(final double balance) {
        if (balance < 0) {
            System.out.println("Balance can not be negative!");
            return;
        }

        this.balance = balance;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

}
