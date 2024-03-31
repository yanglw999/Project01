package com.AbstractAndInterface;

public abstract class Animal {
    public abstract String sound();
}
class Lion extends Animal{
    @Override

    public String sound(){
        return "Angggg...";
    }
}
class Chicken extends Animal implements Edible{
    @Override
    public String sound(){
        return "AOooo...";
    }
    @Override
    public String howToEat(){
        return "fry the chicken";
    }
}
