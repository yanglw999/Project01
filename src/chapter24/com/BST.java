package chapter24.com;

import java.util.ArrayList;
import java.util.Iterator;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    // inner class
    private class TreeNode<E extends Comparable<E>>{
        E element;
        TreeNode<E> left;
        TreeNode<E> right;
        public TreeNode( E e){
            element = e;
        }
    }
    // data field
    protected TreeNode<E> root;
    protected int size;
    public BST(){
    }
    public BST(E [] array){
        for(int i = 0; i < array.length; i++){
            insert(array[i]);
        }
    }
    @Override
    public boolean insert(E e){
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        if(current == null) { // case 1:
            root = newNode(e);
        }else {
            while (current != null) { // case 2
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                    // the conditions quiting while() loop
                } else { // 1. if e already exists, quit the entire method
                    //2. it runs down to bottom of tree until current == null
                    // System.out.println("the element has been the tree, so do not need to insert again.");
                    return false;
                }
            }

            if (e.compareTo(parent.element) < 0) {
                parent.left = newNode(e);
            } else {
                parent.right = newNode(e);
            }
        }
        size++;
        return true;
    }
    public TreeNode<E> newNode(E e){
        return new TreeNode<>(e);
    }
    @Override
    public boolean search(E e){
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        if(current == null){
            return false;
        }
        while (current != null){
            if(e.compareTo(current.element) < 0){
                current = current.left;
            }else if(e.compareTo(current.element) > 0){
                current = current.right;
            }else{
                System.out.println("yes, it it's in the tree!!!");
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean delete(E e){
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        if(current == null){
            return false;
        }else {
            while (current != null){
                if(e.compareTo(current.element) < 0){
                    parent = current;
                    current = current.left;
                }else if(e.compareTo(current.element) > 0){
                    parent = current;
                    current = current.right;
                }else{
                    break; // e exists in tree
                }
            }
            if (current == null)
                return false; // go down to the bottom of tree, but did not find e

            // if e is in the tree, execute below coding
            if(current.left == null){ // case1
                if(parent == null){
                    root = current.right;
                }else {
                    if (e.compareTo(parent.element) < 0) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            }else{ // case 2
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;
                if(rightMost.right != null) {
                    while (rightMost.right != null) {
                        parentOfRightMost = rightMost;
                        rightMost = rightMost.right;
                    }
                    current.element = rightMost.element; // only replace the element
                  //  rightMost = rightMost.left;
                    parentOfRightMost.right = rightMost.left;
                }else {
                    current.element = rightMost.element;
                    rightMost = rightMost.left;
                }
            }
        }

        size --;
        return true;
    }
    @Override
    public void inorder(){
        inorder(root);
    }
    public void inorder(TreeNode<E> root){
        if(root == null) return; // matters, it's terminate sign
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }
    @Override
    public void postorder(){
        postorder(root);
    }
    public void postorder(TreeNode<E> root){
        if(root == null) return; // matters, it's terminate sign
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }
    @Override
    public void preorder(){
        preorder(root);
    }
    public void preorder(TreeNode<E> root){
        if(root == null) return; // matters, it's terminate sign
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public int getSize(){
        return size;
    }
    public void clear(){
        root = null;
        size = 0;
    }
    public Iterator<E> iterator(){
        return new InorderIterator();
    }
    //
    public class InorderIterator implements Iterator<E>{
        // override the abstract methods in Iterator
        private ArrayList<E> list = new ArrayList<>();
        int current = 0;

        private void inorder(){
            inorder( root);
        }
        private void inorder(TreeNode<E> root){
            if (root == null) return;
            InorderIterator.this.inorder(root.left);
            list.add(root.element); // add all elements in list
            inorder(root.right);
        }
        public InorderIterator(){
            inorder();
        }
        // overrides the methods: next(), hasNext()
        @Override
        public boolean hasNext(){
            return current < getSize();
        }
        @Override
        public E next(){
            return list.get(current++);
        }
        @Override
        public void remove(){
            if(current == 0){
                throw new IllegalStateException("next() has not been called yet");
            }
            delete(list.get(--current));
            list.clear();
            inorder();// rebuild list, so low efficiency
        }

    }

}
