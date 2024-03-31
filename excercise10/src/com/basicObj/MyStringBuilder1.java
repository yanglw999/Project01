package com.basicObj;

public class MyStringBuilder1 {
    StringBuilder s;
    public MyStringBuilder1(StringBuilder s){
        this.s = s;
    }
    public MyStringBuilder1 (String s){
        this.s = new StringBuilder(s);
    }

    public MyStringBuilder1 append(MyStringBuilder1 s){
        return new MyStringBuilder1(getS().append(s.getS()));
    }
    public MyStringBuilder1 append(int i){
        return new MyStringBuilder1(getS().append(i));
    }

    public StringBuilder getS() {
        return s;
    }

    public void setS(StringBuilder s) {
        this.s = s;
    }
    public int length(){
        return s.length();
    }
    public char charAt(int index){
        return s.charAt(index);
    }
    public MyStringBuilder1 toLowerCase(){
        StringBuilder str = new StringBuilder("");
      for(int i = 0; i < s.length(); i++){
          str = str.append(Character.toLowerCase(s.charAt(i)));
      }
        return new MyStringBuilder1(str);
    }
    public MyStringBuilder1 substring(int begin, int end){
        StringBuilder str = new StringBuilder("");
        for(int i = begin; i < end; i++){
            str = str.append(charAt(i));
        }
        return new MyStringBuilder1(str);
    }
    public String toString(){
        return s.toString();
    }
}
