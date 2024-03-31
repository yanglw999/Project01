package com.otherClass;

// generics on methods,
// do not need to declare generics class but a particular method still can apply generics
public class Generics2 {
   // private T, P num;
    public <T> T getNum(T num){
        return num;
    }
    public <T> void setNum(T num){
        System.out.println(num);
    }

    public static <T> T getFlag(T flag){
        return flag;
    }
    public static <T> void setSth (T sth){
        System.out.println(sth);
    }
    //
    public <T> void variableParameter(T ... args){
        for(T t : args){
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
class test2{
    public static void main(String[] args) {
        Generics2 g2 = new Generics2();
        g2.setNum(5); //调用方法的时候，不需要像泛型类那样告诉编译器是什么类型，编译器可以根据变量类型自动推断出类型来
        g2.setNum("khj");
        String name = g2.getNum("Tom");
        System.out.println(name);

        System.out.println(Generics2.getFlag("red"));
        Generics2 g3 = new Generics2();
        Integer[]list = new Integer[]{1, 2, 3, 4}; // Integer not int
        g3.variableParameter(list);
    }
}
