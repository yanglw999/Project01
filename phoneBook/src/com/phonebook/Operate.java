package com.phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Operate {
    // core class
    private List<Person> list;
    public Operate(){

        list = new ArrayList<>();
    }
    public void addLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true){// while() is use to stop the method from ending
            menu.addMenu();
            int key = regex.menuItemValidate(1,3);
            switch (key){
                case 1 : this. addOperation(); break;
                case 2 : this. showAll(); break;
                case 3 : return; // return to last page
            }
        }

    }
    public void searchLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true){
            menu.searchMenu();
            int key = regex.menuItemValidate(1,7);
            switch (key){
                case 1 : this.searchByName(); break;
                case 2 : this.searchByAge(); break;
                case 3 : this.searchByGender(); break;
                case 4 : this.searchByTelNum(); break;
                case 5 : this.searchByAddress(); break;
                case 6 : this.showAll();break;
                case 7 : return;
            }
        }
    }
    public void modifyLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true){
            menu.modifyMenu();
            int key = regex.menuItemValidate(1,3);
            switch (key){
                case 1: this.showAll(); break;
                case 2: this.modifyOperation(); break;
                case 3: return;
            }
        }
    }
    public void deleteLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true){
            menu.deleteMenu();
            int key = regex.menuItemValidate(1,4);
            switch (key){
                case 1: this.showAll(); break;
                case 2: this.deleteOperation(); break;
                case 3: this.deleteAllOperation(); break;
                case 4: return;
            }
        }
    }
    public void orderLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true){
            menu.orderMenu();
            int key = regex.menuItemValidate(1,5);
            switch (key){
                case 1: this.orderName(); break;
                case 2: this.orderAge(); break;
                case 3: this.orderSex(); break;
                case 4: this.showAll(); break;
                case 5: return;
            }
        }
    }

    public void addOperation(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        String name = telNoteRegex.nameValidate();
        String age = telNoteRegex.ageValidate();
        String gender = telNoteRegex.genderValidate();
        String telNum = telNoteRegex.telNumValidate();
        String address = telNoteRegex.addressValidate();

        Person person = new Person(name, age, gender,telNum,address);
        list.add(person);
        person.setId(list.size());
    }
    public void searchByName(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        String name = telNoteRegex.nameValidate();
        boolean flag = false;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().equals(name)){
                flag = true;
                System.out.println(list.get(i).toString());
                // break; since we print all entries with same names
            }
        }
        if(flag == false)
            System.out.println("No entry of this person in phone book");

    }
    public void searchByAge(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        String age = telNoteRegex.ageValidate();
        boolean flag = true;

            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getAge().equals(age)){//equals() has less restriction
                    flag = false;
                    System.out.println(list.get(i).toString());
                }
            }
        if(flag)
            System.out.println("No entry for this age.");
    }
    public void searchByGender(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        String gender = telNoteRegex.genderValidate();
        boolean flag = true;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getSex().equalsIgnoreCase(gender)){
                flag = false;
                System.out.println(list.get(i));
            }
        }
        if (flag)
            System.out.println("no entry for the gender.");
    }
    public void searchByTelNum(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        String telNum = telNoteRegex.telNumValidate();
        boolean flag = true;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getTelNum().equals(telNum)){
                flag = false;
                System.out.println(list.get(i));
            }
        }
        if (flag)
            System.out.println("no entry for the phone number.");
    }
    public void searchByAddress(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        String address = telNoteRegex.addressValidate();
        boolean flag = true;
        for(int i = 0; i < list.size(); i++){
            if(address.equals(list.get(i).getAddress())){
                flag = false;
                System.out.println(list.get(i));
            }
        }
        if (flag)
            System.out.println("no entry for the address.");
    }

    public void showAll(){
        if(list.size() > 0){
            for(Person element : list){
                System.out.println(element);
            }
        }else{
            System.out.println("the phone note is empty!");
        }
    }
    public void modifyOperation(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        Menu menu = new Menu();
        System.out.println("please enter entry#: ");
        int key = telNoteRegex.menuItemValidate(1, list.size());
        menu.subModifyMenu();
        System.out.println("please select the num of the property to modify: ");
        int choice = telNoteRegex.menuItemValidate(1,6);

        /**for(int i = 0; i < list.size(); i++) {// can use for(), but less efficiency
            if(key == list.get(i).getId()){}
        }*/
                switch (choice){
                    case 1: list.get(key - 1 ).setName(telNoteRegex.nameValidate()); break;
                    case 2: list.get(key - 1 ).setAge(telNoteRegex.ageValidate()); break;
                    case 3: list.get(key - 1 ).setSex(telNoteRegex.genderValidate()); break;
                    case 4: list.get(key - 1 ).setTelNum(telNoteRegex.telNumValidate()); break;
                    case 5: list.get(key - 1 ).setAddress(telNoteRegex.addressValidate()); break;
                    case 6: return;
                }
    }
    public void deleteOperation(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        System.out.println("please enter the entry #: ");
        int entryNum = telNoteRegex.menuItemValidate(1,list.size());
        list.remove(list.get(entryNum - 1));
        // reset the entry # for left entries
        for(int i = 0; i < list.size(); i++){
            list.get(i).setId(i + 1);
        }
        System.out.println("delete is done, go next...");
    }
    public void deleteAllOperation(){
        list.clear();
        System.out.println("all entries are cleared ");
    }
    public void orderName(){
        Collections.sort(list,new orderByName());
        // reset the entry#
        for(int i = 0; i < list.size(); i++){
            list.get(i).setId(i + 1);
        }
      //  list.forEach( e -> System.out.println(e));
    }
    public void orderAge() {
        Collections.sort(list, new orderByAge());
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setId(i + 1);
        }
    }
    public void orderSex(){
        Collections.sort(list,new orderByGender());
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setId(i + 1);
        }
    }
    // inner class
    class orderByName implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            if(o1.getName().compareTo(o2.getName()) == 0){
              return o1.getAge().compareTo(o2.getAge());
            }else{
                return o1.getName().compareTo(o2.getName());
            }
        }
    }
    class orderByAge implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            if(o1.getAge().compareTo(o2.getAge()) == 0){
                if(o1.getName().compareTo(o1.getName()) == 0){
                    return o1.getTelNum().compareTo(o2.getTelNum());
                }else{
                    return o1.getName().compareTo(o1.getName());
                }
            }else {
                return o1.getAge().compareTo(o2.getAge());
            }
        }
    }
    class orderByGender implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            if(o1.getSex().compareTo(o2.getSex()) == 0){
                if(o1.getName().compareTo(o2.getName()) == 0){
                    return o1.getAge().compareTo(o2.getAge());
                }else{
                  return o1.getName().compareTo(o2.getName());
                }
            }else{
                return o1.getSex().compareTo(o2.getSex());
            }
        }
    }
}
