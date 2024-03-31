package chapter24.com;

import java.util.LinkedList;

public class GenericQueue<E> {
    private LinkedList<E> linkedList = new LinkedList<>();
    public void enqueue(E e){
        linkedList.addLast(e);
    }
    public E dequeue(){
        return linkedList.removeFirst();
    }
    public int getSize(){
        return linkedList.size();
    }
    @Override
    public String toString(){
        return "queue: " + linkedList.toString();
    }
}
