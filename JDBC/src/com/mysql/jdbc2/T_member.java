package com.mysql.jdbc2;

import java.util.Date;

public class T_member { // t_member table
    private int id;
    private String name;
    private char gender;
    private int age;
    private Date registerDate;
    private String className;
    private String email;

    public T_member() {
    }

    public T_member(String name, char gender, int age, Date registerDate, String className, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.registerDate = registerDate;
        this.className = className;
        this.email = email;
    }

    public T_member(int id, String name, char gender, int age, Date registerDate, String className, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.registerDate = registerDate;
        this.className = className;
        this.email = email;
    }

    @Override
    public String toString() {
        return "T_member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", registerDate=" + registerDate +
                ", className='" + className + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public String getClassName() {
        return className;
    }

    public String getEmail() {
        return email;
    }
}
