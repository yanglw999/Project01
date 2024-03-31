package com.generic;

import java.util.ArrayList;

public class GenericStack<E> { //composition different from extends SuperClass
    // composition
    public ArrayList<E> list = new ArrayList<>();

    public GenericStack(){ //non-args constructor

    }

    public void push(E ele){
        list.add( ele);
    }
    public E pop(){
        int index = list.size() - 1;
        E o = list.get(index);
        list.remove(index);
        return o;
    }
    public E peek(){
        return list.get(list.size() - 1);
    }
    // @Override since did not extend SuperClass, do not need use @override
    public boolean isEmpty(){
        return list.size() == 0;
    }
    @Override
    public String toString(){
        return "stack" + list.toString();
    }
}
