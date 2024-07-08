package chapter24.com;

public interface MySet<E> extends Iterable<E> {
    // public abstract can be omitted in interface
    void clear();
    boolean contains(E e);
    boolean add(E e);
    boolean remove(E e);
    boolean isEmpty();
    int size();
}
