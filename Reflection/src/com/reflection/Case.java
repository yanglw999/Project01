package com.reflection;
import java.lang.reflect.Method;

public class Case {
    public void method1(){
        System.out.println("method 1..........");
    }
    public void method2(){
        System.out.println("method 2..........");
    }
    public void method3(){
        System.out.println("method 3..........");
    }
}
class CaseDemo{
    public static void main(String[] args) throws Exception {
        Case c = new Case();
        Class clazz = Case.class;
        Object obj = clazz.newInstance();
        if(args != null && args.length > 0){
            Method[] methods = clazz.getDeclaredMethods();
            for(Method m : methods){
                for(int i = 0; i < args.length; i++){
                    if(m.getName().equalsIgnoreCase(args[i])){
                        m.invoke(obj); // obj can be replaced by c
                        break;
                    }
                }
            }
        }else{
            c.method1(); // c can not be replaced by obj
            c.method2();
            c.method3();
        }
    }
}
