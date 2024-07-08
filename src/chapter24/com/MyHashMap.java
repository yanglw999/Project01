package chapter24.com;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MyHashMap<K, V>implements MyMap<K,V> {
    private static int DEFAULT_INITIAL_CAPACITY = 4;
    // since it's binary, bit shit shift has higher efficiency
    private static int MAXIMUM_CAPACITY = 1 << 30;
    private int capacity;
    private static float DEFAULT_MAX_LOAD_FACTOR = .75f;
    private float loadFactorThreshold;
    private int size = 0;
    // hash table is an array with each cell being a linked list
    LinkedList[] table;
    // each array cell stores one linked list,
    // each cell of linked list stores the one object of MyMap.Entry<K,V>
    public MyHashMap(){
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }
    public MyHashMap(int capacity){
        this(capacity, DEFAULT_MAX_LOAD_FACTOR);
    }
    public MyHashMap(int initialCapacity, float loadFactor){
        if (initialCapacity > MAXIMUM_CAPACITY)
            this.capacity = MAXIMUM_CAPACITY;
        else
            capacity = trimPowerOf2(initialCapacity);
        loadFactorThreshold = loadFactor;
        // array.length == capacity
        table = new LinkedList[capacity];// capacity is the length of table
    }
    private int trimPowerOf2(int initialCapacity){
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<=1;

        return capacity;
    }
    @Override
    public boolean containsKey(K key){
        if(get(key) != null)
            return true;
        else
            return false;
    }
    @Override//$$$
    public boolean containsValue(V value){
        for(int i = 0; i < capacity; i++){
            if(table[i] != null){
                LinkedList<MyMap.Entry<K,V>> subList = table[i];// table[i] is a LinkedList
                for(MyMap.Entry<K,V> entry : subList){
                    if (entry.getValue().equals(value)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public Set<MyMap.Entry<K,V>> entrySet(){
        Set<MyMap.Entry<K,V>> hashSet = new HashSet<>();
        for(int i = 0; i < capacity; i++){
            if(table[i] != null){
                LinkedList<MyMap.Entry<K,V>> subList = table[i];
                for(MyMap.Entry<K,V> entry : subList){
                    hashSet.add(entry);
                }
            }
        }
        return hashSet;
    }
    // if one key only has one exclusive value, getSimple(K key) works
    public V getSimple(K key){
        for(int i = 0; i < capacity; i++){
            if(table[i] != null){
                LinkedList<MyMap.Entry<K,V>> subList = table[i];
                for(MyMap.Entry<K,V> entry : subList){
                    if(entry.getKey().equals(key)){
                        return entry.getValue();
                    }
                }
            }
        }
        return null;
    }
    @Override// since one key might have two or more corresponding values
    // hashcode is introduced to distinguish each value
    public V get(K key){
        int hashIndex = hash(key.hashCode());

            if(table[hashIndex] != null){ //table[index] is LinkedList
                LinkedList<MyMap.Entry<K,V>> subList = table[hashIndex];
                for(MyMap.Entry<K,V> entry : subList){
                    if(entry.getKey().equals(key)){
                        return entry.getValue();
                    }
                }
            }

        return null;
    }
    private int hash(int hashCode){
        return supplementalHash(hashCode) &(capacity - 1);
    }
    private static int supplementalHash(int h){
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
   @Override
   public void remove(K key){
        int hashIndex = hash(key.hashCode());
        if(table[hashIndex] != null){
            LinkedList<MyMap.Entry<K,V>> subList = table[hashIndex];
            for (MyMap.Entry<K,V> entry : subList){
               if(entry.getKey().equals(key)){
                   table[hashIndex].remove(entry);
                   size--;
                   break;
               }
            }
        }
   }
    private void rehash(){
        Set<MyMap.Entry<K,V>> hashSet = entrySet();
        capacity <<= 1; // same as capacity *= 2;
        table = new LinkedList[capacity];
        size = 0;
        for(Entry<K,V> entry : hashSet){
            this.put(entry.getKey(), entry.getValue());// implicitly size++
        }
    }
   @Override
   public V put(K key, V value){
        if(get(key) != null){ // case 1, key already exists
            int hashIndex = hash(key.hashCode());
            LinkedList<MyMap.Entry<K,V>> list = table[hashIndex];
            for(Entry<K,V> entry : list){
                if(entry.getKey().equals(key)){
                    V oldV = entry.getValue();
                    entry.value = value;
                    return oldV;
                }
            }
        }
        // check load factor
       if(size >= capacity * loadFactorThreshold){
           if(capacity == MAXIMUM_CAPACITY) {
               throw new RuntimeException("Exceeding maximum capacity");
           }
           rehash();
       }
       // case 2: key does not exist in table
       int hashIndex = hash(key.hashCode());
       if(table[hashIndex] == null){
           table[hashIndex] = new LinkedList<MyMap.Entry<K,V>>();
       }
       table[hashIndex].add(new Entry<>(key,value));
       size++;
       return value;

   }
    @Override
    public Set<K> keySet(){
        Set<K> hashSet = new HashSet<K>();// second K is optional
        for(int i = 0; i < capacity; i++){
            if(table[i] != null) {
                LinkedList<MyMap.Entry<K, V>> subList = table[i];
                for (MyMap.Entry<K, V> entry :subList)
                    hashSet.add(entry.getKey());
            }

        }
        return hashSet;
    }
    @Override
    public Set<V> values(){
        Set<V> hashSet = new HashSet<>();
        for(int i = 0; i < capacity; i++){
            if(table[i] != null){
                //each table[i] stores j Entry<K,v> objects
                LinkedList<MyMap.Entry<K,V>> subList = table[i];
                for (int j = 0; j < subList.size(); j++)
                    hashSet.add(subList.get(j).getValue());
            }
        }
        return hashSet;
    }
    @Override
    public void clear(){
        size = 0;
        removeEntries();
    }
    //remove all entries
    public void removeEntries(){
        for(int i = 0; i < capacity; i++){
            if(table[i] != null){
                table[i].clear();
                //table[i] = null;// no needed, since implemented in LinkedList.clear()
            }
        }
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("[");
        for(int i = 0; i < capacity; i++){

            if (table[i] != null && table[i].size() > 0){
                LinkedList<MyMap.Entry<K,V>> subList = table[i];
                for(MyMap.Entry<K,V> entry : subList){
                   /** { // since having been overridden in Entry<K,V>
                        builder.append(entry.getKey());
                        builder.append(" > ");
                        builder.append(entry.getValue());
                    } */
                   builder.append(entry);
                }
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
