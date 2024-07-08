package com.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SetAccessibleTest {
    public static void main(String[] args) throws Exception {
        Class laptopClass = Laptop.class;
        Laptop laptop = (Laptop) laptopClass.newInstance();
        Field fieldBrand = laptopClass.getDeclaredField("brand");
        // after setAccessible(true), it closes the function to check access permission
        // the corresponding private field can be invoked in other class
        fieldBrand.setAccessible(true);
        fieldBrand.set(laptop,"Snmsung");
        System.out.println(fieldBrand.get(laptop));
        Method methodTest = laptopClass.getDeclaredMethod("test");
        methodTest.setAccessible(true);// closed the function to check
        System.out.print("test() running result: ");
        methodTest.invoke(laptop);
    }
}
