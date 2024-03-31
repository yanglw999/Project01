package com.generic;

public class Exercise19_4 {
    public static void main(String[] args) {
        Integer[] intArray = {5,4,6,8,3,12}; // must be Integer instead of int
        // instance of linearSearch()
        int key = 3;
        int index = Exercise19_4.<Integer>linearSearch(intArray,3);
        System.out.println("the index of " + key + " in intArray: " + index);
        // example of max()
        int max = Exercise19_4.<Integer>max(intArray);
        System.out.println("max of the array: " + max);
        // example of sort()
        Exercise19_4.<Integer>sort(intArray);
        for(Integer ele : intArray){
            System.out.print(ele + " ");
        }
        System.out.println();
        // binarySearch()
        System.out.println(Exercise19_4.<Integer>binarySearch(intArray, 8));


    }
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key){
        for(int i = 0; i < list.length; i++){
         if(key.compareTo(list[i]) == 0)
             return i;
        }
        return -1;
    }
    public static <E extends Comparable<E>> E max(E[] list){
        E [] arrayTemp = list;
        E max = list[0];
        int index = 0;
        for(int i = 1; i < list.length; i++){
            if(max.compareTo(list[i] ) == -1){
                max = list[i];
                index = i;
            }
        }
        return max;
    }
    public static <E extends Comparable<E>> void sort(E[] array){
        for(int i = 0; i < array.length; i++){
            E min = array[i];
            int index = i;
            for(int j = i + 1; j < array.length; j++){
                if(min.compareTo(array[j]) == 1){
                    min = array[j];
                    index = j;
                }
            }
            if(i != index){
                E temp = array[i];
                array[i] = min;
                array[index] = temp;

            }
        }
    }
    public static <E extends Comparable<E>> int binarySearch(E[] array, E key){
        Exercise19_4.<E>sort( array);
        int high = array.length - 1;
        int low = 0;
        int index = -1;
        for(; low <= high; ){//     while(low <= high){}
            if(key.compareTo(array[(low + high)/2]) == -1){
                high = (low + high)/2 - 1;
            }else if(key.compareTo(array[(low + high)/2]) == 1){
                low = (low + high)/2 + 1;
            }else {
                return (low + high)/2;
            }
        }
        return index;
    }
}
