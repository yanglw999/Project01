package com.basicObj;

public class MyCharacter {
    private char ch;
    public MyCharacter(char ch){
        this.ch = ch;
    }
    public MyCharacter(){

    }
    public int compareTo(MyCharacter myCharacter){
        return ch - myCharacter.ch;
    }
    public boolean equals(MyCharacter myCharacter){
        return ch == myCharacter.ch;
    }
    public boolean isDigit(){ // instance method boolean method has no args
        return isDigit(this.ch);
    }
    public boolean isDigitOrLetter(){
        return isLetter(this.ch) || isDigit(this.ch);
    }
    public static boolean isDigit(char ch){ // static method, static method is arg-method
        return (ch >= '0' && ch <= '9');
    }
    public static boolean isLetter(char ch){
        return ((ch <= 'z' && ch >= 'a')||(ch <= 'Z'&& ch >= 'A'));
    }
    public static boolean isDigitOrLetter(char ch){
        return isDigit(ch)||isLetter(ch);
    }
    public boolean isLowerCase(){
        return isLowerCase(this.ch) ; // instance method can invoke static method
    }
    public static boolean isLowerCase(char ch){
      return   (ch <= 'z' && ch >= 'a');
    }
    public boolean isUpperCase(){
        return isUpperCase(this.ch);
    }
    public static boolean isUpperCase(char ch){
        return (ch <= 'Z' && ch >= 'A');
    }
    public char toUpperCase(){
        return toUpperCase(this.ch);
    }
    public static char toUpperCase(char ch){
        if(isLowerCase(ch)){
            return(char) ((ch - 'a') + 'A'); // '' + int -> int
        }else {
            return ch;
        }
    }
    public char toLowerCase(){
        return toUpperCase(ch);
    }
    public static char toLowerCase(char ch){
        if(isUpperCase(ch)){
            return  (char)(ch - 'A' + 'a');
        }else{
            return ch;
        }
    }
}
