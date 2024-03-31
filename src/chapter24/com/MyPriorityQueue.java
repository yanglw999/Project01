package chapter24.com;

// the objects in PriorityQueue must have the feature of sorting (comparable)
public class MyPriorityQueue<E extends Comparable<E>> {
    private Heap<E> heap = new Heap<>();
    public void enqueue(E object){
        heap.add(object);
    }
    public E dequeue(){

        return heap.remove();
    }
    public int getSize(){
        return heap.getSize();
    }
}
