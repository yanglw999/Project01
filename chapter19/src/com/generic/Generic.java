package com.generic;

public class Generic<T> {// since class has declare T, so methods does not need <T>
    private T sign;
// if class defined as generic<T>,
// instance void method does not need <T>

    public void setSign(T sign) {
        this.sign = sign;
    }

    public T getSign() {
        return sign;
    }

    public static void main(String[] args) {
        //length is array property which returns how many elements array can save
        int [] arr = new int[10];
        System.out.println(arr.length); // return 10
    }
}
class GenericMethod{
    // if class is defined without<T>,
    // the void method can define T with <T> ahead of void
    public <T> void setSign(T sign){
        System.out.println(sign);
    }
    //get method even does not need to define var independently
    public <T> T getSign(T sign){//<T> is to declare T type
        return sign;
    }
    // static method generic
    public static<T> void setFlag(T flag){
        System.out.println(flag);
    }
    public static <T> T getFlag(T flag){
        return flag;
    }
    // method with changeable args, args usually is an array
    public <T> void changeableMethod(T ... args){
        for(T t : args){
            System.out.print(t + " ");
        }
    }
    public static <T> void StaticChangeableMethod(T ... args){
        for(T t : args){
            System.out.print(t + " ");
        }
    }
}
