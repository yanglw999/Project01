package chapter24.com;

import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    int size = 0;
    public MyLinkedList(){}
    public MyLinkedList(E [] objects){
        for(int i = 0; i < objects.length; i++){
            add(objects[i]); // add(E e) is implemented in MyList interface
        }
    }
    public E getFirst(){
        if(size == 0)
            return null;
        return head.element;
    }
    public E getLast(){
        if (size == 0){
            return null;
        }else {
            return tail.element;
        }
    }
    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        if(size == 0){
            head = newNode;
            tail = head;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void addLast(E e){
        Node<E>  newNode = new Node<>(e);
        if(tail == null){
            head = newNode;
            tail = head;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public void add(int index, E e){
        Node<E> newNode = new Node<>(e);
        if(index <= 0){
           addFirst(e);
        }else if(index >= size){
            addLast(e);
        }else {
            Node<E> current = head;
            for(int i = 1; i < index; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }
    public E removeFirst(){
        if(size == 0){
            return null;
        }else{
            E e = head.element;
            head = head.next;
            size--;
            if(size == 0){
                head = tail = null;
            }
            return e;
        }
    }
    public E removeLast(){
        if(size == 0){
            return null;
        }else{
            Node<E> current = head;
            for(int i = 1; i < size - 1; i++){
                current = current.next;
            }
            E e = tail.element;
            tail = current;
            current.next = null;// very important
            size --;
            if(size == 0){
                head = tail = null;
            }
            return e;
        }
    }
    @Override
    public E remove(int index){
        if(index < 0 || index >= size){
           return null;
        }else if(index == 0){
            return removeFirst(); // removeFirst() has its own return, but still needs write return here
        }else if(index == size -1){
            return removeLast();
        }else {
            Node<E> current = head;
            for(int i = 1; i < index; i++){
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = temp.next;
            size --;
            return temp.element;
        }

    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("]");
        Node<E> current = head;
        for(int i = 0; i < size; i++){ //  while(current.next != null){} does not work
            str.append(current.element);

            if(current.next != null){
                str.append(", ");
            }else {
                str.append("]");
            }
            current = current.next;
        }
        return str.toString();
    }
    @Override
    public void clear(){
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object e){ // return (indexOf(e) > 0);
        Node<E> current = head;
        for(int i = 0; i < size; i++){
            if(current.element == e){
                return true;
            }else {
               current = current.next;
            }
        }
        return false;
    }
    @Override
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index should be between 0 and size -1");
        }
        Node<E> current = head;
        if(index == 0){
            return head.element;
        }else {
            for (int i = 1; i <= index; i++) {
                current = current.next;
            }
            return current.element;
        }
    }
    @Override
    public int indexOf(Object e){
        Node<E> current = head;
        for(int i = 0; i < size; i++){
            if(current.element == e){
                return i;
            }
            current = current.next;
        }
        return -1;
    }
    @Override // very important
    public int lastIndexOf(E e){
        int lastIndex = -1;
        Node<E> current = head;
        for(int i = 0; i < size; i++){
            if(current.element == e){
                lastIndex =  i;
            }
            current = current.next;
        }
        return lastIndex;
    }
    @Override
    public E set(int index, E e){
       E v = get(index);
        if(index == 0) {
            head.element = e;
            return v;
        }
        Node<E> current = head;
        for(int i = 1; i <= index; i++){ // very important
            current = current.next;
        }
        current.element = e;
        return v;
    }
    @Override
    public Iterator<E> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E>{
        private Node<E> current = head;
        @Override
        public boolean hasNext(){
            return (current.next != null);
        }
        @Override//$$$$
        public E next(){
            E e = current.element;
            current = current.next;
            return e;
        }
        @Override // remove the element returned by the last next()
        public void remove(){
            if(current.element == head.element){ // next is not called yet
                throw new IllegalStateException();
            }


        }
    }




    private static class Node<E>{
        E element;
        Node<E> next;
        public Node(E e){
            element = e;
        }
    }

}

