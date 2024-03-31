package chapter24.com;

import java.util.ArrayList;

public class GenericStack<E> {
    private ArrayList<E> list = new ArrayList<>();

    public int getSize(){
        return list.size();
    }
    public E peek(){ // return the last element
        return list.get(list.size() -1); // list.get(getSize() - 1);
    }
    public void push(E e){
        list.add(e);
    }
    public E pop(){ // return and remove the last element
        E e = list.get(getSize() - 1);
        list.remove(list.size() - 1);
        return e;
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    @Override
    public String toString(){
        return "stack: " + list.toString();
    }
}
