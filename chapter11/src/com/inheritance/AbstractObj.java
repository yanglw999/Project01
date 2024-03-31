package com.inheritance;

public abstract class AbstractObj implements Comparable<AbstractObj> {
    private boolean fill;
    public AbstractObj(){

    }
    public AbstractObj(boolean fill){
        setFill(fill);
    }
    public void setFill(boolean fill){
        this.fill = fill;
    }
    public abstract double getArea();
    @Override // compareTo defined in Comparable interface
    public int compareTo(AbstractObj obj){
        if(getArea() > obj.getArea()){
            return 1;
        }else if(getArea() < obj.getArea()){
            return -1;
        }else{
            return 0;
        }
    }
     // equals defined in Object class
    public boolean equals(AbstractObj obj) {
        return getArea() == obj.getArea();
    }
    @Override
    public String toString(){
        return "fill: " + fill;
    }
}
