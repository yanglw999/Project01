package com.AbstractAndInterface;

import java.util.Date;

public class House implements Cloneable, Comparable<House> {
    private int id;
    private double area;
    private Date whenBuilt;
    public House(){
        whenBuilt = new Date();
    }
    public House(int id, double area){
        this.id = id;
        this.area = area;
        whenBuilt = new Date();
    }
    public double getArea(){
        return area;
    }
    // protected clone() already defined in Object class, override it and strengthen its accessibility
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override // if implements Comparable<>, compareTo() must be overrode
    public int compareTo(House o){
        if(getArea() > o.getArea()){
            return 1;
        }else if(getArea() == o.getArea()){
            return 0;
        }else {
            return -1;
        }

    }
}
