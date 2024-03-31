package com.generic;

import java.util.ArrayList;

public class Exercise19_3 {
    public static void main(String[] args) {
        GeneticStackList<Integer> intNum = new GeneticStackList<>();
        intNum.push(new Integer(7));
        intNum.push(3);
        intNum.push(5);
        intNum.push(6);
        intNum.push(5);
        intNum.push(6);
        System.out.println("intNum size:" + intNum.size());

        GeneticStackList<Integer> uniqueList = GeneticStackList.<Integer>removeDuplicates(intNum);
        for (Integer i : uniqueList) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < uniqueList.size(); i++) {
            System.out.print(uniqueList.get(i) + " ");
        }
        // uniqueList.size() does not work, since uniqueList is from static method, but size()is instance,
        // static method cannot invoke instance method
        System.out.println("uniqueList size: " + uniqueList.size()); // this invoking is incorrect


        ArrayList<Integer> unique = GeneticStackList.<Integer>Unique(intNum);
        for (Integer i : uniqueList) {
            System.out.print(i + " ");
        }
    }

}
