package chapter24.com;

import java.util.Collection;
// in abstract class, 'abstract' must be put ahead of abstract method, but in interface it does not
public interface MyList<E> extends Collection<E> { //Using 'extends' to connect parent interface and sub-interface
    // 1
    public void add(int index, E e);// will be overridden in child class
    //2
    public E get(int index);
    //3
    public int indexOf(Object e);
    //4
    public int lastIndexOf(E e);
    //5
    public E remove(int index);
    //6
    public E set(int index, E e);
    //7
    @Override
    public default boolean add(E e){ // 7 & 9 are based on 1 & 5, which are overridden in subClass
        add(size(), e);
        return true;
    }
    //8
    @Override
    public default boolean isEmpty(){
        return size()==0;
    }
    //9 @Override
    public default boolean remove(Object e){ // distinguish E remove(int index)
        if(indexOf((E) e) >= 0){
            remove(indexOf((E) e)); //E remove(int index)
            return true;
        }else
            return false;
    }
    // contains()

    public default boolean contains( Object e){
       /* if (indexOf(e) >= 0)
            return true;
        return false; */
       return (indexOf(e) >= 0);
    }
    //10 $$$$
    @Override
    public default boolean containsAll(Collection<?> c){
        for(Object e : c){
            if(!this.contains(e))
                return false;
        }
        return true;
    }
    //11@Override
    public default boolean addAll(Collection<? extends E> c){ // the reason of using MyList instead of Collection
        for(Object e : c)  //MyList has method get(int index)
            add((E) e);
     // check whether c is not empty
        if(c.size() > 0)
            return true;
        else
            return false;
    }
    //9
    /*public default boolean remove(E e){
        if(indexOf(e) >= 0){
            remove(indexOf(e)); //E remove(int index)
            return true;
        }else
            return false;
    } */
    //12
    public default boolean removeAll(Collection<?> c){
        boolean changed = false;
        for(Object e : c){
            if(remove(e))
                changed = true;
        }
        return changed;
    }
    //13
    public default boolean retainAll(Collection<?> c){
        boolean changed = false;
        for(int i = 0; i < size();){ //$$$
            if(!c.contains(this.get(i))){
                remove(this.get(i));
                changed = true;
            }
            else i++;
        }
        return changed;
    }
    //14
    public default Object[] toArray(){
        return null;
    }
    //15
    public default <T> T[] toArray(T[] array){
        return null;
    }
}
