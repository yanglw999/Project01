package com.collect;

import java.util.*;

public class Exercise20_1 {
    public static void main(String[] args) {
        System.out.print("write a sentence:      ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String [] tokens = str.split("[, ;.?/]");
        List<String> words = Arrays.asList(tokens);
        words.sort((s1,s2) -> s1.charAt(0) -s2.charAt(0));
        ListIterator<String> listIterator = words.listIterator();
        while (listIterator.hasNext()){
            System.out.print(listIterator.next() + " ");
        }
    }
}
