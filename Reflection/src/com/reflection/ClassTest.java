package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassTest {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("MacBook Air",2000);
        //1. get class by object.getClass()
        Class class1 = laptop1.getClass();
        System.out.println("laptop1: " + class1);
        //2. get class by static property: class
        Class class2 = Laptop.class;
        System.out.println("class2: " + class2);
        //3. static forName() in Class class
        try{
            Class class3 = Class.forName("com.reflection.Laptop");
            System.out.println("class3: " + class3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Constructor
        Constructor[] arr = class2.getDeclaredConstructors();
        for(Constructor e : arr){
            System.out.println(e);
        }
        // get constructor with particular args-type
        System.out.println("\n---- constructors with args-type-----");
        try{
            Constructor cstr = class2.getDeclaredConstructor(String.class, double.class);
            System.out.println(cstr);
            // using returned constructor to new instance
            System.out.println("\n------using returned constructor to new instance----");
            Object o = cstr.newInstance("ASUS", 2000);
            if(o instanceof Laptop){
                Laptop laptop2 = (Laptop) o;
                System.out.println(laptop2);
            }
            System.out.println("\n----------Access to class dataField members------------");
            Field[] fields = class2.getDeclaredFields();
            for(Field ele: fields){
                System.out.println(ele);
            }
            System.out.println("--------access a particular data field member----------");
            Field field = class2.getField("price"); // access a public member
            System.out.println(field);
            System.out.println("----set a value to data field-------");
            //Ahead set value to data field, class must instantiate first
            field.set(o, 3000); //o is the refVar of an particular instance
            System.out.println("new price: " + field.get(o));
            System.out.println("--------access to methods----------");
            Method[] methods = class2.getDeclaredMethods();
            for(Method m : methods){
                System.out.println(m);
            }
            System.out.println("\n--------set/ get methods test---------");
            // precondition: instantiate the class
            Method methodSet = class2.getDeclaredMethod("setBrand", String.class);
            methodSet.invoke(o,"Lenovo");
            Method methodGet = class2.getMethod("getBrand");//if no args, just skip
            System.out.println(methodGet);
            Object value = methodGet.invoke(o);
            System.out.println(value);
            System.out.println("\n---------access other class info----------");
            System.out.println("class name: " + class2.getName());
            Package pack = class2.getPackage();
            System.out.println("package name: " + pack);
            Class superClass = class2.getSuperclass();
            System.out.println("parent class: " + superClass);
            System.out.println("--------access the interfaces------");
            Class[] interfaces = class2.getInterfaces();
            for(Class i: interfaces){
                System.out.println(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
