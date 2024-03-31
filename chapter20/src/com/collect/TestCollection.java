
import java.util.*;

public class TestCollection {
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<>();
        c1.add("A");
        c1.add("b");
        c1.add("c");
        c1.add("D");
        System.out.print("the collection 1: ");
        System.out.println(c1);
        // clone()
        ArrayList<String> c2 = (ArrayList<String>) ((ArrayList<String>) c1).clone();
        System.out.print("the collection 2: ");
        System.out.println(c2);

        System.out.print("1. print all elements by iterator: ");
        Iterator<String> collectionIterator = c1.iterator();
        while (collectionIterator.hasNext()){
            System.out.print(collectionIterator.next().toUpperCase() + " ");
        }
        System.out.println();
        // forEach() is under Collection instead of iterator
        System.out.print("2. print all elements via forEach(): ");
        c2.forEach(e -> System.out.print(e.toLowerCase() + " "));
        System.out.println();

        System.out.print("3. print all elements through ListIterator & previous(): ");
        List list1 = Arrays.asList("e","F","G","H"); // $$$$
        ListIterator<String> listIterator = list1.listIterator(list1.size());
        while (listIterator.hasPrevious()){
            System.out.print(listIterator.previous().toUpperCase() + " ");
        }
        System.out.println();
        System.out.print("4. new LinkedList<>(list1) application: ");
        LinkedList<Object> linkedList = new LinkedList<Object>(list1);
        linkedList.addFirst(6);
        linkedList.removeLast();// no value in ()
        linkedList.forEach(e -> System.out.print(e + " "));


    }
}
