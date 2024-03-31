package com.basicObj;

public class MyString1 {
    private char[]chars;

    public MyString1(char[] chars){
        this.chars = new char [chars.length];
        System.arraycopy(chars,0,this.chars,0,chars.length);
    }
    public char charAt(int index){
        return this.chars[index];
    }
    public int length(){
        return chars.length;
    }
    public MyString1 substring(int begin, int end){
        char[] temp = new char[end -begin];
        for(int i = begin; i < end; i++){
           temp[i - begin] = this.chars[i];
        }
        return new MyString1(temp); // return to dataField chars[]

    }
    public MyString1 toLowerCase(){
        char [] temp = new char[chars.length];
        for(int i = 0; i < chars.length; i++){
            temp[i] = Character.toLowerCase(chars[i]);
        }
        return new MyString1(temp); // return to dataField chars[]
    }
    public boolean equals(MyString1 s){
        boolean equal = true;
        if(chars.length != s.chars.length){
            equal = false;
        }else{
            for(int i = 0; i < s.chars.length; i++){
                if(chars[i] != s.chars[0]){
                    equal = false;
                    break;
                }
            }

        }
        return equal;
    }
    public static MyString1 valueOf(int i){
        char[]temp = new char[40];
        int size = 0;
        while (i != 0){
            int r = i % 10;
            temp[size]  = (char)(r + '0');
            i /= 10;
            size++;
        }
        char[]temp1 = new char[size];
        for(int j = size-1; j >= 0; j--){
            temp1[j] = temp[size-1 - j];
        }
        return new MyString1(temp1);
    }
    // must override toChars() to return the char array
    public char[] toChars(){
        return chars;
    }
}
