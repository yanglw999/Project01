package com.example;

public class Course {                  // System.arraycopy(array0,0,array1,0, array0.length)
    private String courseName;
    private String[] students = new String[1];
    private int numOfStudents;
    public Course(String courseName){
        this.courseName = courseName;
    }
    public String getCourseName(){
        return courseName;
    }
    public void addStudent(String student){
        if(numOfStudents >= students.length){
            String[] temp = new String[students.length + 1];
            System.arraycopy(students,0, temp,0,students.length);
            students = temp;
        }
        students[numOfStudents] = student;
        numOfStudents++;
    }
    public int getArrayLength(){
        return students.length;
    }

    public void dropStudent(){
        if(numOfStudents > 0) {
            String [] temp = new String [students.length -1];
            System.arraycopy(students,0,temp,0,students.length - 1);
            students = temp;
        }
        numOfStudents--;
    }
    public String  drop(){
       numOfStudents--;
        return students[numOfStudents];
    }
    public String[] getStudents(){
        return students;
    }
    public int getNumOfStudents(){
        return numOfStudents;
    }
    public boolean isEmpty(){
        return numOfStudents == 0;
    }
    public void clear(){
        numOfStudents = 0;
    }
}
