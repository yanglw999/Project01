package com.generic;

import java.util.ArrayList;

public class GeneticStackList<E> extends ArrayList<E> {

    private ArrayList<E> arrayList;

    public GeneticStackList(){
        arrayList = new ArrayList<>();
    }
    public void push(E ele){
        arrayList.add( ele);
    }
    public E pop(){
        int index = arrayList.size() - 1;
        E o = arrayList.get(index);
        arrayList.remove(index);
        return o;
    }
    public E peek(){
        return arrayList.get(arrayList.size() - 1);
    }
    @Override
   public boolean isEmpty(){
        return arrayList.size() == 0;
   }
   @Override
    public String toString(){
        return "stack" + arrayList.toString();
   }
   public int size(){
        return arrayList.size();
   }
   public E get(int i){
        return arrayList.get(i);
   }

   public static <E> GeneticStackList<E> removeDuplicates(GeneticStackList<E> list){
        GeneticStackList<E> listTemp = new GeneticStackList<>() ;
        for(int i = 0; i < list.size(); i++){

            if(! listTemp.contains(list.get(i))){

                listTemp.add(list.get(i));
            }
        }
        return listTemp;
   }
   public static <E> ArrayList<E> Unique(GeneticStackList<E> list){
       ArrayList<E> listTemp = new GeneticStackList<>() ;
       for(int i = 0; i < list.size(); i++){

           if(! listTemp.contains(list.get(i))){

               listTemp.add(list.get(i));
           }
       }
       return listTemp;
   }
}
