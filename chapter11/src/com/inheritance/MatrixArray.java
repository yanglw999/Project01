package com.inheritance;
import java.util.ArrayList;
public class MatrixArray {
    public static void main(String[] args) {
        matrix(5,6);
    }
    public static void matrix(int row, int volume) {
        int[][] m = new int[row][volume];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < volume; j++) {
                m[i][j] = (int) (Math.random() + 0.5);
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        ArrayList<Integer> r = new ArrayList<>();
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            Integer s = 0;
            for (int j = 0; j < volume; j++) {
                s = s + m[i][j];
            }
            r.add(s);
        }
        System.out.println("sum of each row: " + r.toString());
        System.out.println("the first row with most \"1\": " + (r.indexOf(java.util.Collections.max(r)) + 1));
        System.out.print("the rows with most \"1\": ");
        for (int i = 0; i < r.size(); i++) {
            if (java.util.Collections.max(r) == r.get(i))
                System.out.print((i + 1) + ", ");
        }
        System.out.println();
        for (int j = 0; j < volume; j++) {
            Integer s = 0;
            for (int i = 0; i < row; i++) {
                s = s + m[i][j];  // m[row][volume] is fixed
            }
            v.add(s);
        }
        System.out.println("sum of each volume: " + v.toString());
        System.out.println("the first volume with most \"1\": " + (v.indexOf(java.util.Collections.max(v)) + 1));
        System.out.print("the volumes with most \"1\": ");
        for (int i = 0; i < v.size(); i++) {
            if (java.util.Collections.max(v) == v.get(i))
                System.out.print((i + 1) + ", ");
        }

    }
}
