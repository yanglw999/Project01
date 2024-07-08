package chapter24.com;

import java.util.Iterator;

public class BSTTest {
    public static void main(String[] args) {
        Integer [] nums = {5,3,9,7,5,6,4,2,10,12,21,50};
        BST<Integer> bst = new BST<>(nums);
        bst.insert(3);
        System.out.println(bst.search(9));
        System.out.println(bst.getSize());
        bst.delete(100);
        bst.delete(12);
        bst.delete(21);
        bst.inorder();
        System.out.println();
        Iterator<Integer> iterator = bst.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " " );
        }
    }
}
