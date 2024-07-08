package chapter24.com;

import java.util.Set;

public interface MyMap<K, V> {
    // public abstract ahead of abstract methods are omitted
    void clear();
    boolean containsKey(K key);
    boolean containsValue(V value);
    Set<Entry<K, V>> entrySet();
    V get(K key);
    boolean isEmpty();
    Set<K> keySet();
    Set<V> values();
    V put(K key, V value);
    void remove(K key);
    int size();

    // inner class
    class Entry<K, V>{
        K key;
        V value;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        @Override // inherited from Object class
        public String toString(){
            return "[" + getKey() + " -> " + getValue() + "]";
        }
    }
}
