package com.generic;

public class Exercise19_2 {
    public static void main(String[] args) {
        GeneticStackList<String> list = new GeneticStackList<>();
       for(int i = 0; i < 5; i++){
          // char ch = 'A' + i
           list.push((char)('A' + i ) + "");
       }
        System.out.println("list size: " + list.size());
        while(!list.isEmpty()){
            System.out.print(list.pop() + " ");
        }
        System.out.println();
        //
        GenericStack<String> list1 = new GenericStack<>();
        for(int i = 0; i < 5; i++){
            // char ch = 'A' + i

            list1.push((char)('A' + i ) + "");
        }
        while(!list1.isEmpty()){
            System.out.print(list1.pop() + " ");
        }
    }
}
