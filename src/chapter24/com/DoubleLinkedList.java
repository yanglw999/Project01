package chapter24.com;

public class DoubleLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;

    private static class Node<E>{
        E element;
        Node<E> next;
        Node<E> previous;
        public Node(E e){
            element = e;
        }
    }

    public int getSize(){
        return this.size;
    }
    public DoubleLinkedList(){

    }
    public DoubleLinkedList(E [] array){
        for(int i = 0; i < array.length; i++){
            this.add(array[i]);
        }
    }
    public boolean add(E e){

       add(size, e);
       return true;
    }
    public void add(int index, E e){

        if(index <= 0){
            addFirst(e);
        }else if(index >= size){
            addLast(e);
        }else {
            Node<E> newNode = new Node<>(e);
            Node<E> current = head;
            for(int i = 1; i < index; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }
    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        if (size == 0) {
            head = newNode;
            tail = head;
        }else{
            head.previous = newNode;
            head = newNode;
            head.previous = null;
        }
        size++;

    }
    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        if(tail == null){
            head = newNode;
            tail = head;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public E remove(int index){
        if(index < 0 || index >= size){
            System.out.println("index must between 0 and size -1 !!!");
            return null;
        }
        if(index == 0){
            removeFirst();
        }
        if(index == size - 1){
            removeLast();
        }

        {
            Node<E> current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            E e = current.element;
            (current.previous).next = current.next;
            size--;
            return e;
        }
    }
    public E removeFirst(){
        if (size == 0){
            System.out.println("It's empty, so nothing to remove!");
            return null;
        }else{
            E e = head.element;
            head = head.next;
            head.previous = null;
            size--;
            if(size == 0){
                head = tail = null;
            }
            return e;
        }
    }
    public E removeLast(){
        if (size == 0){
            System.out.println("It's empty, so nothing to remove!");
            return null;
        }else{
            E e = tail.element;
            // if without previous, it has to use for-loop to move to the predecessor of tail
            tail = tail.previous;
            tail.next = null; // put null on can speed up the garbage collection
            size--;
            if(size == 0){
                head = tail = null;
            }
            return e;
        }
    }
    public E get(int index){
        if(index < 0 || index >= size){// or !(index >= 0 && index < this.size)
            System.out.println("index should be between 0 and size -1 !");
            return null;
        }
        if(index == 0){ // special case
            return head.element;
        }
        if(index == size - 1){ // special case
            return tail.element;
        }
        // regular way
      /*  Node<E> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.element;

       */
      // better way
        Node<E> node = this.getNode(index);
        return node.element;

    }
    private Node getNode(int index){
        //$$$$
        // decide which end is closer to index
        Node<E> node;
        if(index < this.size >> 1){
            node = head;
            for(int i = 0; i < index; i++){
                node = node.next;
            }
        }else {
            node = this.tail;
            for(int i = this.size - 1; i > index; i--){
                node = node.previous;
            }
        }
        return node;
    }
}
