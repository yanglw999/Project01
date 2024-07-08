package com.jdbc.personprj.entity;

import java.util.Date;

public class Person {
    private int id;
    private String name;
    private  int age;
    private Date birthDate;
    private String email;

    public Person() {
    }

    public Person(String name, int age, Date birthDate, String email) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.email = email;
    }

    public Person(int id, String name, int age, Date birthDate, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
