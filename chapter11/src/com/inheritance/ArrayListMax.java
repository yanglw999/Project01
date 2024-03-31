package com.inheritance;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListMax {
    public static void main(String[] args) {
        System.out.println(" input a set of numbers: ");
        ArrayList <Integer> nums = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        while(i != 0){
            nums.add(i);
            i = input.nextInt();
        }
        System.out.println("the max num： " + max(nums));

    }
    public static Integer max(ArrayList<Integer> list){
        if(list.size() == 0 || list == null){
            return null;
        }
        java.util.Collections.sort(list);
        return list.get(list.size() - 1);
    }
}
