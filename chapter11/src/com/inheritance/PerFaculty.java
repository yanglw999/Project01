package com.inheritance;

public class PerFaculty extends PerEmployee {
    double workTime;
    String rank;
    public PerFaculty(String frank, String s, String associate){

    }
    public PerFaculty(String name, String address, String ceil, String email, int officeNum, double salary, double workTime,String rank){
        super(name,address,ceil,email,officeNum,salary);
        this.workTime = workTime;
        this.rank = rank;
    }
    String getRank(){
        return rank;
    }
    double getWorkTime(){
        return workTime;
    }
    @Override//如果一个方法在父类中定义为 public, 在子类中也必须定义为 public；但不能由public 到 protected， 可见性减弱.
    public String toString(){
        return super.toString() + " work time: " + this.workTime + " rank: " + getRank();
    }
}
