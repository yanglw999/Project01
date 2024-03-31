package com.obj.exercise;

public class Stock {
    String symbol;
    String name;
    double previousClosingP;
    private double currentP;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }
    Stock(String s, String n, double pp, double cp){
       this(s,n);
        previousClosingP = pp;
        currentP = cp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getChangePercentage(){
        return (currentP / previousClosingP - 1) * 100;
    }
    public double getCurrentP(){
        return currentP;
    }
    public void setCurrentP(double newCurrentP){
        currentP = newCurrentP;
    }

}
