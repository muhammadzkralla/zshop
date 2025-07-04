package com.zkrallah.zshop.customer;

interface CustomerService {
    double updateBalance(Customer customer, double newBalance);

    String updateLocation(Customer customer, String newLocation);

    void checkout(Customer customer);
}
