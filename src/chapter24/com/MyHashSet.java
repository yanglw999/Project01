package chapter24.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet<E> implements MySet<E>{
    private static int DEFAULT_INITIAL_CAPACITY = 4;
    private static int MAXIMUM_CAPACITY = 1 << 30;
    private int capacity;
    private static float DEFAULT_MAX_LOAD_FACTOR = .75f;
    private float loadFactorThreshold;
    private int size = 0;
    private LinkedList<E>[] table;
    public MyHashSet(){
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }
    public MyHashSet(int initialCapacity){
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }
    public MyHashSet(int initialCapacity, float loadFactorThreshold){
        if (initialCapacity > MAXIMUM_CAPACITY)
            capacity = MAXIMUM_CAPACITY;
        else
            this.capacity = trimToPower2(initialCapacity);
        this.loadFactorThreshold = loadFactorThreshold;
        table = new LinkedList[capacity];
    }
    private int trimToPower2(int initialCapacity){
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1;
        }
        return capacity;
    }
    @Override
    public boolean contains(E e){
        int hashIndex = hash(e.hashCode());
        // hashIndex helps reduce the double loops into single loop
        // it improves the efficiency and reduces the consumption of time
        if (table[hashIndex] != null){
            LinkedList<E> list = table[hashIndex];
            for (E element : list){
                if(element.equals(e)){
                    return true;
                }
            }
        }
        return false;
    }
    private int hash(int hashCode){
        return supplementalHash(hashCode) &(capacity -1 );
    }
    private static int supplementalHash(int h){
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
    @Override
    public boolean remove(E e){
        // case 1: it does not contain e
        if (!this.contains(e))
            return false;
        // case 2: it certainly contains e
        int hashIndex = hash(e.hashCode());
        if(table[hashIndex] != null){
            LinkedList<E>  list = table[hashIndex];
            for(E element : list){
                if (element.equals(e)){
                    list.remove(e);
                    break;
                }
            }
        }
        size--;
        return true;
    }
    @Override
    public boolean add(E e){
        // case 1: it contains e
        if (contains(e)) //table[hashIndex] != null
            return false;
        if(size + 1 > capacity * loadFactorThreshold){
            if(capacity == MAXIMUM_CAPACITY) {
                throw new RuntimeException("Exceeding the max capacity.");
            }
            rehash();
        }
        // case 2: it does not contain e
        int hashIndex = hash(e.hashCode());
        if(table[hashIndex] == null){
            table[hashIndex] = new LinkedList<>();
            table[hashIndex].add(e);
        }

        return true;
    }
    private void rehash(){
        ArrayList<E> tempList = setToList();
        capacity <<= 1; // capacity *= 2
        size = 0;
        table = new LinkedList[capacity];
        for(E e : tempList){
            this.add(e);
        }
    }
    private ArrayList<E> setToList(){
        ArrayList<E> setToList = new ArrayList<>();
        for(int i = 0; i < capacity; i++){
            if (table[i] != null){
                LinkedList<E> tableI = table[i];
                for(E e : tableI){
                    setToList.add(e);
                }
            }
        }
        return setToList;
    }
    @Override
    public void clear(){
        size = 0;
        removeElements();
    }
    public void removeElements(){
        for(int i = 0; i < capacity; i++){
            if(table[i] != null){
                table[i].clear();
            }
        }
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("[");
        ArrayList<E> setToList = setToList();
        //case 1: setToList.size() != 0
       for(int i = 0; i < setToList.size() -1 ; i++){
           builder.append(setToList.get(i) + ", ");
       }
       // case 2: setToList.size() == 0
        if(setToList.size() == 0)
            builder.append("]");
        else
            builder.append(setToList.get(setToList.size() -1) + "]");
        return builder.toString();
    }
    // Iterable<E> interface
    public Iterator<E> iterator(){
        return new IteratorSet(this);
    }
    // inner class
    private class IteratorSet implements Iterator<E>{
        private ArrayList<E> list;
        private int current = 0;
        MyHashSet<E> set;// refVar directly points at the original set in outer class
        public IteratorSet(){
            list = setToList();
        }
        public IteratorSet(MyHashSet<E> set){
            this.set = set;
            list = setToList();
        }
        @Override
        public boolean hasNext() {
            return current < size; // size from outer class
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        @Override
        public void remove() {
            // remove directly changed the original set
            set.remove(list.get(current));
            list.remove(current);

        }
    }
}
