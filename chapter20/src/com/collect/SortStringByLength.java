package com.collect;

import java.util.*;

public class SortStringByLength {

    public static void main(String[] args) {
        String[]cities = {"LA","Toronto","New York","Shanghai","Seattle","Atlanta"};
        Arrays.sort(cities, new MyComparator());// since Array.sort() is static method, MyComparator must be static class
        System.out.print("1. sort cities by length: ");
        for(String element : cities){
            System.out.print(element + " ");
        }
        System.out.println();

        String[]countries = {"USA","China","UK","Canada","Australia"};
        Arrays.sort(countries, (s1,s2) -> s1.length() - s2.length()); // do not need to declare s1, s2
        System.out.print("2. sort countries in terms of length: ");
        for(String e : countries){
            System.out.print(e + " ");
        }
        System.out.println();

        System.out.print("3. turn the array into List by Array.asList() and invoke the sort(): ");
        List<String> list = Arrays.asList(countries);
        list.sort((s1,s2) -> s1.length() - s2.length());
        list.forEach( e -> System.out.print(e + ", "));
        System.out.println();

        System.out.print("4. listIterator: ");
        List<Person> personList = new LinkedList<>();
        personList.add(new Student(15,165, 2301));
        personList.add(new Student(16,160,2302));
        personList.add(new Teacher(28,173,2303));
        personList.sort((s1, s2) -> s1.getAge() -s2.getAge());
        ListIterator<Person> listIterator = personList.listIterator(personList.size());
        while (listIterator.hasPrevious()){
            System.out.print(listIterator.previous() + "/ ");
        }
        System.out.println();
        System.out.print("5. sort by age and print out by code: ");
        List<Person> list2 = new ArrayList<>();
        Person student1 = new Student(17,165,2301);
        Person student2 = new Student(16,160,2302);
        Person teacher1 = new Teacher(28,180,2303);
        Person teacher2 = new Teacher(22,170,2304);

        list2.add(student1);
        list2.add(student2);
        list2.add(teacher1);
        list2.add(teacher2);
        // also write as: Arrays.sort(list2, Comparator.comparing(Person::getAge));
        list2.sort(Comparator.comparing(Person::getAge));

        ListIterator<Person> listIterator2 = list2.listIterator(list2.size());
        while (listIterator2.hasPrevious()) {
            System.out.print(listIterator2.previous().getCode() + "/ ");
        }
        System.out.println();
        System.out.print("6. sort by age and print out by code: ");
        List<Person> list3 = new ArrayList<>();
        Person teacher3 = new Teacher(28,173,2305);
        list3.add(student1);
        list3.add(student2);
        list3.add(teacher1);
        list3.add(teacher2);
        list3.add(teacher3);
        list3.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getHeight).reversed());
        list3.forEach(e -> System.out.print(e.getCode() + "/ "));
    }
    public static class MyComparator implements Comparator<String>{
        @Override
        public int compare(String s1, String s2){
            return s1.length() - s2.length(); // the type of length difference is always int
        }
    }
}
