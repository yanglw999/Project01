package com.setTest;

import java.util.HashSet;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        HashSet<User> hashSet = new HashSet<>(16,.75f);
        hashSet.add(new User("Jake", 15));
        hashSet.add(new User("Mark", 25));
        hashSet.add(new User("David", 25));

        TreeSet<User> treeSet = new TreeSet<>(hashSet);
        for(User user : treeSet){
            System.out.println(user);
        }
        System.out.println("--------comparator test--------");
        TreeSet<Worker> treeSetComparator = new TreeSet<>(new WorkerComparator());
        treeSetComparator.add(new Worker("James", 15));
        treeSetComparator.add(new Worker("Mary", 25));
        treeSetComparator.add(new Worker("Dicker", 25));
        for(Worker work : treeSetComparator){
            System.out.println(work);
        }
    }
}
