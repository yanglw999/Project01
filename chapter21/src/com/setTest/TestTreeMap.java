package com.setTest;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {
        // User class as K, user has implemented CompareTo
        System.out.println("----------Comparable----------");
        Map<User, String> map = new TreeMap<>();
        User user1 = new User("Jake", 15);
        User user2 = new User("Tom", 25);
        map.put(user1, "Jake");
        map.put(user2, "Tom");

        Set<User> keys = map.keySet();
        for(User k : keys){
            System.out.println(k + " ----> " + map.get(k));
        }
        // Worker class as K, which has a outside Comparator
        System.out.println("----------Comparator----------");
        Map<Worker, String> map1 = new TreeMap<>(new WorkerComparator());
        map1.put(new Worker("John", 15), "John");
        map1.put(new Worker("Tony", 25), "Tony");
        map1.put(new Worker("Anna", 25), "Anna");

        Set<Worker> keys1 = map1.keySet();
        for(Worker key : keys1){
            System.out.println(key + " ->-> " + map1.get(key));
        }
     }
}
