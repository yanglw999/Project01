package com.basicObj;

import com.example.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue();
        for(int i = 0; i < 10; i++){
            queue.lineUp(i);
            System.out.println(java.util.Arrays.toString(queue.getNums()));
        }
    /*    for(int i = 0; i < 5; i++) {
            queue.firstGone();
            queue.restLine();
            System.out.println(java.util.Arrays.toString(queue.getNums()));
        } */
    while(!queue.isEmpty()){
        System.out.print(queue.fifo() + ", ");
    }


    }
}
