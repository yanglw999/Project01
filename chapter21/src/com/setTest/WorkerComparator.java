package com.setTest;
import java.util.Comparator;
public class WorkerComparator implements Comparator<Worker> {
    // write the compare rules
    @Override
    // like global function in C++
    public int compare(Worker o1, Worker o2){
        if (o1.getAge() != o2.getAge()) {
            return o1.getAge() - o2.getAge();
        }else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
