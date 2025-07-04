package com.zkrallah.zshop.product;

public interface Shippable {
    String getName();

    double getWeight();

    // I don't think this is the most clean approach, but I will keep it for now
    // as it's working
    void setWeight(double weight);
}
