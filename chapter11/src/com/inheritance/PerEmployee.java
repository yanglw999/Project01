package com.inheritance;

import java.util.Date;

public class PerEmployee extends Person {
    int Office;
    double salary;
    Date dateEmployed;
    public PerEmployee(){

    }
    public PerEmployee(String name, String address, String ceil, String email, int officeNum,double salary){
        super(name,address,ceil, email);
        Office = officeNum;
        this.salary = salary;
        dateEmployed = new Date();
    }

    public void setDateEmployed(Date dateEmployed) {
        this.dateEmployed = dateEmployed;
    }

    int getOffice(){
        return Office;
    }
    double getSalary(){
        return salary;
    }
    public String toString(){
        return super.toString() + " office num: " + getOffice() + " salary: " + salary;
    }
}



