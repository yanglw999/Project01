package chapter24.com;

import java.util.ArrayList;
// the objects in heap must have the feature of sorting (comparable)
public class Heap<E extends Comparable<E>> {
    private ArrayList<E> list = new ArrayList<>();
    public Heap(){}
    public Heap(E[] objects){
        for(int i = 0; i < objects.length; i++){
            list.add(objects[i]);
        }
    }
    public void add(E e){
        list.add(e);
        int currentIndex = list.size() -1;
        while (currentIndex > 0){
            int parentIndex = (currentIndex - 1) / 2;
            if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
                E temp = list.get(parentIndex);
                list.set(parentIndex, list.get(currentIndex));
                list.set(currentIndex,temp);
            }else
                break;
            currentIndex = parentIndex;
        }
    }

    public E remove(){
        if(list.size() == 0) return null;

        E e = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);//$$$$ the element on size - 1 has been moved to index 0,
        int currentIndex = 0;              // so it needs to be removed from size-1
        // otherwise, it will repeat unlimitedly and list size will not decline

        while(currentIndex < list.size()){
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            if(leftChildIndex >= list.size()){break;}
            int maxIndex = leftChildIndex;
            if(rightChildIndex < list.size()){
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
