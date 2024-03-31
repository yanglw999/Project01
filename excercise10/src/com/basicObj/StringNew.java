package com.basicObj;

public class StringNew {
    String str = "";
    public StringNew(String str){
        this.str = str;
    }
    public String[] split(String regex){
        return split(this.str,regex);
    }
    public static String[] split(String s, String regex){
        String [] strings = new String[s.length()];
      /*  char[] chars = new char[s.length()];
        char[]express = new char[regex.length()];
        for(int i = 0; i < s.length(); i++){
            chars[i] = s.charAt(i);
        }
        for(int i = 0; i < regex.length(); i++){
            express[i] = regex.charAt(i);
        }

       */
        int pointer = 0;
        int size = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < regex.length(); j++) {
                if (s.charAt(i) == regex.charAt(j)) {
                    strings[size] = (s.substring(pointer, i) + s.charAt(i));
                    size++;
                    pointer = i + 1;
                }

            }

        }
        strings[size] = s.substring(pointer, s.length() - 1);
        String[] strings1 = new String[size];
        for(int i = 0; i < size; i++){
            strings1[i] = strings[i];
        }
        return strings1;
    }

}
