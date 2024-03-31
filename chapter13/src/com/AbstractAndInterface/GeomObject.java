package com.AbstractAndInterface;

import java.util.Date;

public abstract class GeomObject {
    private String color = "";
    private boolean filled;
    private Date dateCreated;
    protected GeomObject(){
        dateCreated = new Date();
    }
    protected GeomObject(String color, boolean filled){
        dateCreated = new Date();
        this.color = color;
        setFilled(filled);

    }
    public void setColor(String color){
        this.color=color;
    }
    public String getColor(){
        return color;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    public boolean isFilled(){
        return filled;
    }
    public void setDateCreated(Date dateCreated){
        this.dateCreated = dateCreated;
    }
    public Date getDateCreated(){
        return dateCreated;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    @Override
    public String toString(){
        return "created on " + getDateCreated() + "color: " + color;
    }
}
