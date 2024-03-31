package chapter24.com;

public class TestPriorityQueue {

    public static void main(String[] args) {
        Patient patient1 = new Patient("A",2);
        Patient patient2 = new Patient("B", 1);
        Patient patient3 = new Patient("C",5);
        Patient patient4 = new Patient("D", 7);
        MyPriorityQueue<Patient> priorityQueue = new MyPriorityQueue<>();
        priorityQueue.enqueue(patient1);
        priorityQueue.enqueue(patient2);
        priorityQueue.enqueue(patient3);
        priorityQueue.enqueue(patient4);
        while (priorityQueue.getSize() > 0){
            System.out.print(priorityQueue.dequeue().toString() +" ");
        }
    }
}

class Patient implements Comparable<Patient>{
    private String name;
    private int priority;
    public Patient(){

    }
    public Patient(String name, int priority){
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Patient patient) {
        return this.priority - patient.priority;
    }
    @Override
    public String toString(){
        return name + "(priority: " + priority + ")";
    }
}
