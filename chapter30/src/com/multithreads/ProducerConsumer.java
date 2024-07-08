package com.multithreads;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ProducerConsumer {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for(int i = 1; i <= 100; i++){
            list.add(i);
        }
        Buffer<Integer> buffer = new Buffer<>(5);
        // two tasks share buffer by constructors
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new ProducerTask<>(buffer,list));
        service.execute(new ConsumerTask<>(buffer, list.size()));
        service.shutdown();
    }
}
class ProducerTask<E> implements Runnable{
    private Buffer<E> buffer;
    private List<E> list;

    public ProducerTask(Buffer<E> buffer, List list) {
        this.buffer = buffer;
        this.list = list;
    }

    @Override
    public void run() {
        try {
                for(E e : list){
                    buffer.write( e);
                    Thread.sleep(500);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
    }
}
class ConsumerTask<E> implements Runnable{
    private Buffer<E> buffer;
    int size;
    public ConsumerTask(Buffer<E> buffer, int size) {
        this.buffer = buffer;
        this.size = size;
    }
    @Override
    public void run() {
        try {
        int i = 0;
          while (i < size){
               E ele = buffer.read( );
                ++i;
                if(i % 10 == 0)
                    System.out.println(ele + " ");
                else
                    System.out.print( ele + " ");
              Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Buffer<E>{
    private int capacity = 10;
    private LinkedList<E> queue = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public Buffer(int capacity) {
        this.capacity = capacity;
    }
    public void write(E element) {
        lock.lock();
            try {
                while (queue.size() == capacity){
                    System.out.println("buffer is full, so wait.");
                    notFull.await();
                }
                queue.add(element);
                notEmpty.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
    }
    public E read(){
        E value = null;
        lock.lock();
        try{
            while (queue.isEmpty()){
                System.out.println("buffer is empty, so hold on.");
                notEmpty.await();
            }
          value = queue.removeFirst();
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            return value;
        }
    }
}