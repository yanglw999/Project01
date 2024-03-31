public class StrClass {
    public static void main(String[] args) {
        String a = String.valueOf(2356);
        StringBuilder b = new StringBuilder("\"Hello ");
        b.append("Beijing");
        System.out.println(b);
        StringBuilder c = b;
        c.delete(0,1);
        System.out.println(c);
        c.insert(0, 123);
        System.out.println(c);

    }
}
