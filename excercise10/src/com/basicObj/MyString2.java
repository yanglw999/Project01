package com.basicObj;

import javax.xml.stream.events.Characters;

public class MyString2 {
    private String s;
    private String subStr = "";
    //StringBuilder strUpper
    private String strUpper = "";
    public MyString2( String s){
        this.s = s;
    }
    public MyString2 subString(int begin){
        for(int i = begin; i < s.length(); i++){
            subStr += (s.charAt(i) + "");
        }
        return new MyString2(subStr);
    }
    public MyString2 toUpperCase(){
        for(int i = 0; i < s.length(); i++){
           // strUpper = new StringBuilder(strUpper).append( Character.toUpperCase(s.charAt(i)));
            strUpper += String.valueOf(Character.toUpperCase(s.charAt(i)));
        }
        // String st = strUpper.toString();
        return new MyString2(strUpper);
    }
    public char[] toChars(){
        char[] chars = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            chars[i] = s.charAt(i);
        }
        return chars;
    }
    public int compare(String s){
        return this.s.compareTo(s);
    }
    public String toString(){ // to return the String s
        return s;
    }
}
