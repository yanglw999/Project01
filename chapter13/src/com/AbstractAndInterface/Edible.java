package com.AbstractAndInterface;

public interface Edible { //所有的变量必须是 'public static final'但是可以省略
    public abstract String howToEat(); //所有的方法必须是 public abstract instance 实例方法，而不是static
}
abstract class Fruit implements Edible{// class implements interface

}
class Orange extends Fruit implements Edible{
    @Override
    public String howToEat(){
        return "ground juice";
    }
}
// SubClass extends SuperClass
// interface extends interface