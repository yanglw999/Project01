package com.setTest;

import java.util.HashSet;

public class TestHashCode {
    public static void main(String[] args) {
        User user1 = new User("longwei", 30);
        User user2 = new User("longwei", 30);
        HashSet<User> hashSet = new HashSet<>();
        hashSet.add(user1);
        hashSet.add(user2);
        for(User user: hashSet){
            System.out.println(user);
        }
        System.out.println("hashCode of user1: " + user1.hashCode());
        System.out.println("hashCode of user2: " + user2.hashCode());

    }
}
