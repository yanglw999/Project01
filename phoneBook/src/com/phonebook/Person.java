package com.phonebook;

public class Person {
    private  int id;
    private String name;
    private String age;
    private String sex;
    private String telNum; // phone num exceeds int arrangement
    private String address;

    public Person(String name, String age, String sex, String telNum, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.telNum = telNum;
        this.address = address;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getTelNum() {
        return telNum;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#: ").append(String.format("%-5d",id)).append("\t");
        stringBuilder.append("name: ").append(String.format("%-10s", this.name)).append("\t").append("\t");
        stringBuilder.append("age: ").append(this.age).append("\t\t");
        stringBuilder.append("gender: ").append(this.sex).append("\t\t");
        stringBuilder.append("phone#: ").append(this.telNum).append("\t\t");
        stringBuilder.append("address ").append(this.address);
        return stringBuilder.toString();
    }
}
