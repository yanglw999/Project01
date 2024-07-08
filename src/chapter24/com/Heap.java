package chapter24.com;
//$$$$$ Heap has the sort function internally,
// but others like Array, ArrayList, LinkedList, Queue do not have.
// Priority Queue also has the function internally, that’s why it uses Heap to build
import java.util.ArrayList;
// compareTo() defines the sort rules
// thus, E class must have implemented CompareTo(E o) method
public class Heap<E extends Comparable<E>> {
    private ArrayList<E> list;
    public Heap(){
        list = new ArrayList<>();
    }
    public Heap(E[] objects){
        list = new ArrayList<>();
        for(int i = 0; i < objects.length; i++){
            list.add(objects[i]);
        }
    }
    public void add(E e){
        list.add(e);
        int currentIndex = list.size() -1;
        // in heap, the biggest object is put in root @ index = 0
        while (currentIndex > 0){
            int parentIndex = (currentIndex - 1) / 2;
            // must use compareTo() to compare, since it wrote the comparison rule
            if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
                E temp = list.get(parentIndex);
                list.set(parentIndex, list.get(currentIndex));
                list.set(currentIndex,temp);
            }else {
                break;
            }

            currentIndex = parentIndex;
        }
    }

    public E remove(){
        if(list.size() == 0) return null;

        E e = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        // the element on size - 1 has been moved to index 0,
        // so it needs to be removed from size-1
        int currentIndex = 0;
        // otherwise, it will repeat unlimitedly and list size will not decline
        while(currentIndex < list.size()){
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            if(leftChildIndex >= list.size()){break;} // have been the bottom of the heap

            int maxIndex = leftChildIndex;
            if(rightChildIndex < list.size()){//rightChildIndex exists
                if(list.get(rightChildIndex).compareTo(list.get(maxIndex)) > 0){
                    maxIndex = rightChildIndex;
                }
            }

            if(list.get(currentIndex).compareTo(list.get(maxIndex)) < 0){
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(maxIndex));
                list.set(maxIndex, temp);
                currentIndex = maxIndex; // the statement location is very important
            }else
                break;
        }

        return e;
    }

    public int getSize(){
        return list.size();
    }
}
