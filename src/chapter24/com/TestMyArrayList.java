package chapter24.com;

;

public class TestMyArrayList {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>(); // the reason choosing MyList<E> over Collection<E> is MyList has more methods
        list.add("America");
        System.out.println("1: " + list.toString());
        list.add(0,"Canada");
        System.out.println("2: " + list);
        list.add("Russia");
        System.out.println("3: " + list);
        list.add("France");
        System.out.println("4: " + list);
        list.add(2,"Germany");
        System.out.println("5: " + list.toString());
        list.add(5,"Norway");
        System.out.println("6: " + list);
        list.remove("Canada");
        System.out.println("7: " + list);
        list.remove(2);
        System.out.println("8: " + list);
        list.remove(list.size() -1);
        System.out.println("9: " + list);
    }
}
