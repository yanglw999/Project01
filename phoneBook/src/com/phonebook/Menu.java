package com.phonebook;

public class Menu {

    public void mainMenu(){
        System.out.println("***********************************");
        System.out.println("************* 1. add **************");
        System.out.println("************* 2. search ***********");
        System.out.println("************* 3. modify ***********");
        System.out.println("************* 4. delete ***********");
        System.out.println("************* 5. sort *************");
        System.out.println("************* 6. exit *************");
        System.out.println("***********************************");
    }

    public void addMenu(){
        System.out.println("***********************************");
        System.out.println("*********** 1. add new entry ******");
        System.out.println("*********** 2. check all **********");
        System.out.println("*********** 3. back to last page **");
        System.out.println("***********************************");
    }
    public void searchMenu(){
        System.out.println("****************************************");
        System.out.println("********* 1. search by name ************");
        System.out.println("********* 2. search by age *************");
        System.out.println("********* 3. search by gender **********");
        System.out.println("********* 4. search by number **********");
        System.out.println("********* 5. search by address *********");
        System.out.println("********* 6. check all entries  ********");
        System.out.println("********* 7. back to last page  ********");
        System.out.println("****************************************");
    }
    public void modifyMenu(){
        System.out.println("***********************************");
        System.out.println("**** 1. view all entries **********");
        System.out.println("**** 2. modify specific entry *****");
        System.out.println("**** 3. back to last page *********");
        System.out.println("***********************************");
    }
    public void subModifyMenu(){
        System.out.println("***********************************");
        System.out.println("**** 1. modify entry name *********");
        System.out.println("**** 2. modify entry age **********");
        System.out.println("**** 3. modify entry gender *******");
        System.out.println("**** 4. modify entry phone number *");
        System.out.println("**** 5. modify entry address ******");
        System.out.println("**** 6. back to last page *********");
        System.out.println("***********************************");
    }
    public void deleteMenu(){
        System.out.println("***********************************");
        System.out.println("**** 1. view all entries **********");
        System.out.println("**** 2. delete specific entry *****");
        System.out.println("**** 3. delete all entries ********");
        System.out.println("**** 4. back to last page *********");
        System.out.println("***********************************");
    }
    public void orderMenu(){
        System.out.println("***********************************");
        System.out.println("********* 1. sort by name *********");
        System.out.println("********* 2. sort by age **********");
        System.out.println("********* 3. sort by gender *******");
        System.out.println("********* 4. view all entries *****");
        System.out.println("********* 5. back to last page ****");
        System.out.println("***********************************");
    }
}
