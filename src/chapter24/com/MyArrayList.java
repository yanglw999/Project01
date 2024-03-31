package chapter24.com;

import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {
    public static final int INITIAL_CAPACITY = 16;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY]; // new Object[n];
    private int size = 0;
    public MyArrayList(){

    }
    public MyArrayList(E[] Objects){
        for(int i = 0; i < Objects.length; i++){
            add(Objects[i]);
        }
    }
    //1
    // @Override
    public void add(int index, E e) {
        checkIndex(index); // precondition 1
        ensureCapacity(); // precondition 2
        for(int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;

        size++;
    }
    //2
    private void ensureCapacity() { // better to put it at bottom
        if(size >= data.length){
            E[] newData = (E[]) new Object[size * 2 + 1];
            System.arraycopy(data,0,newData,0,size);
            data = newData; // garbage collection
        }
    }

    //3
    private void checkIndex(int index) { // better to put it at bottom
        if (index < 0 || index > size) { // using new create an exception object
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
    }
    //4
    @Override
    public E get(int index){
        checkIndex(index);
        return data[index];
    }
    //5
    @Override
    public int indexOf(Object e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }
    //6  compare idea of method 5 with method 6
    @Override
    public int lastIndexOf(E e){
        int index = -1;
        for(int i = size - 1; i >= 0; i--){
            if(e.equals(data[i]))
                index = i;
        }
        return index;
    }
    //7
    @Override
    public E remove(int index){
        checkIndex(index);
        E e = data[index];
        for(int i = index; i < size - 1; i++) // $$$$ size-1 is not used
            data[i] = data[i + 1];

        data[size - 1] = null;// very important
        size--;
        return e;
    }
    //8
    @Override
    public E set(int index, E e){ // add(int index, E e)
        checkIndex(index);
        E oldValue = data[index];
        data[index] = e;
        return oldValue;
    }
    //9
    @Override
    public int size(){
        return size;
    }
    //10
    @Override
    public Iterator<E> iterator(){
        return new ArrayListIterator();
    }
              // internal class
    private class ArrayListIterator implements Iterator<E> {
        private int current = 0;// equal to the pointer
        //11 when pointing at data[0], current = 1; date[size -1] -> current = size
        @Override
        public boolean hasNext(){
            return current < size;
        }
        //12
        @Override
        public E next(){
            return data[current++];
        }
        //13
        @Override
        public void remove(){
            if(current == 0)
                throw new IllegalStateException();//"next() has not been called yet!!"
            MyArrayList.this.remove(--current); // this has new usage
        }
    }
    //14
    public void clear(){
        data = (E[]) new Object[INITIAL_CAPACITY]; // automatically collecting
        size = 0;
    }
    //15
    @Override
    public boolean contains(Object e){
        boolean flag = false;
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                flag = true;
                break;
            }
        }
        return flag;
    }
    //16
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("[");
        for(int i = 0; i <= size - 1; i++) {
            str.append(data[i]);
            if(i < size -1){ // very important
                str.append(", ");
            }
        }
        return str.toString() + "]";
    }
    //17
    public void trimToSize(){
        if(data.length != size){
            E [] newData = (E[]) new Object[size];
            System.arraycopy(data,0,newData,0,size);
            data = newData;
        }
    }
}
