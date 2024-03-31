package com.otherClass;

public class Generics3 { //通配符和上下界
    public void showItem(Generics0<String, Integer> item){
        System.out.println(item.getName());
        System.out.println(item.getAge());
    }
}

class test3{
    public static void main(String[] args) {
        Generics3 g3 = new Generics3();
        Generics0 <String, Integer> g0 = new Generics0<>();
        g0.setAge(20);
        g3.showItem(g0);

    }
}