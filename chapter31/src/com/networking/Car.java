package com.networking;

import java.io.Serializable;
// if one object will be transmitted through internet, it must implement Serializable interface
public class Car implements Serializable {
    private String brand;
    private double price;

    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }
    @Override
    public String toString(){
        return "brand: " + this.brand + ", price: " + this.price;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }
}
