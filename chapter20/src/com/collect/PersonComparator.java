package com.collect;

import java.io.Serializable;
import java.util.Comparator;
// define a comparator
public class PersonComparator implements Comparator<Person>, Serializable {// two interfaces
    @Override
    public int compare(Person p1, Person p2){
        int age1 = p1.getAge();
        int age2 = p2.getAge();

        if(age1 > age2){
            return 1;
        } else if(age1 == age2){
            return 0;
        }
        return -1;
    }
    // can also write as below, if the result type always is int
    // return age1 - age2
}
