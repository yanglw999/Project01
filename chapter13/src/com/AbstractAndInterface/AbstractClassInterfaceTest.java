package com.AbstractAndInterface;

public class AbstractClassInterfaceTest {
    public static void main(String[] args) {
        Object[]objects = {new Lion(),new Chicken(),new Orange()};
        for(int i = 0; i < objects.length; i++){
            if (objects[i] instanceof Animal)
                System.out.println(objects[i] + ":\t\t" + ((Animal)objects[i]).sound());
            if(objects[i] instanceof Edible)
                System.out.println(objects[i] + ":\t\t" + ((Edible)objects[i]).howToEat());
        }
    }
}
