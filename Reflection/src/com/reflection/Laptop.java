package com.reflection;

public class Laptop {
    private String brand;
    public double price;

    public Laptop() {
        this("MacBook Pro",2800);
    }
    private Laptop(String brand){
        this.brand = brand;
    }

    public Laptop(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private void test(){
        System.out.println("just for a test.");
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
