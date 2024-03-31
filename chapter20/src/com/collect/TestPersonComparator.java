package com.collect;

import java.util.Comparator;

public class TestPersonComparator {
    public static void main(String[] args) {
        Person p1 = new Teacher(35,175,1);
        Person p2 = new Student(18,180,2);
        Person older = MaxAge(p1,p2,new PersonComparator());
        System.out.println(((older == p1)? "Teacher" : "Student" ) + " is older.");
    }
    public static Person MaxAge(Person p1, Person p2, Comparator<Person> c){//$$$ Comparator<> or PersonComparator
        if (c.compare(p1,p2) > 0){
            return p1;
        }else {
            return p2;
        }
    }
}
