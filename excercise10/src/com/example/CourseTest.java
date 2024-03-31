package com.example;

public class CourseTest {
    public static void main(String[] args) {
        Course course1 = new Course("Data Structures");

        course1.addStudent("Peter");
        String[] students1 = course1.getStudents();
        System.out.println(java.util.Arrays.toString(students1));
        course1.addStudent("Kim");
        String[] students2 = course1.getStudents();
        System.out.println(java.util.Arrays.toString(students2));
        course1.addStudent("john");
        String[] students3 = course1.getStudents();
        System.out.println(java.util.Arrays.toString(students3));
        course1.addStudent("Emily");
        String[] students4 = course1.getStudents();
        System.out.println(java.util.Arrays.toString(students4));


        course1.dropStudent();
        String[] students5 = course1.getStudents();
        System.out.println(java.util.Arrays.toString(students5));
        course1.dropStudent();
        String[] students6 = course1.getStudents();
        System.out.println(java.util.Arrays.toString(students6));
        course1.dropStudent();
        String[] students7 = course1.getStudents();
        System.out.println(java.util.Arrays.toString(students7));
        course1.dropStudent();
        String[] students8 = course1.getStudents();
        System.out.println(java.util.Arrays.toString(students8));
    }

}
