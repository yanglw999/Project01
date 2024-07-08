package com.basicObj;

public class RegexTest {
    public static void main(String[] args) {
        // content limitation
        String regex0 = "[a]";
        String regex1 = "[a-z]"; // any single letter between a and z
        String regex2 = "[a-zA-Z]";
        String regex3 = "[a-zA-Z0-9]";
        // if did not specify the length explicitly, it's 1 in default
        System.out.println("a: " + ("a".matches(regex0)));
        System.out.println("b: " + "b".matches(regex1));
        System.out.println("A: " + "A".matches(regex1));
        System.out.println("A: " + "A".matches(regex2));
        System.out.println("5: " + "5".matches(regex3));
        // non ^
        String regex4 = "[^ab]"; // the value is not a or b
        System.out.println("^a: " + "a".matches(regex4));

        // length limitation
        String regex5 = "[^ab]{2}"; //non a/b and length must be 2
        System.out.println("cc: " + "cc".matches(regex5));
        String regex6 = "[a-z]{2,8}"; // letters between a and z, length range 2 and 8
        System.out.println("abcdefgh: " + "abcdefgh".matches(regex6));
        // {2, } means, max length is unlimited
        //{0, 5} -> the min length is 0, that is empty length
        String regex7 = "[^ab]?";// ? same as {0,1}
        System.out.println("?: " + "c".matches(regex7));
        String regex8 = "[^ab]+"; // + same as {1,}
        System.out.println("+: " + "ccddddddffffffff".matches(regex8));
        //\d, \D,\W, \w        \n, \r, \s, \S,
        String regex9 = "\\d*"; // \d same as [0-9], * same as {0,}, no space between d and *
        System.out.println("\\d: " + "59858".matches(regex9));
        // \w* same as[A-Za-z0-9_]*
        System.out.println("\\w: " + "abCd9Z_w".matches("\\w*"));
        // \W* same as [^A-Za-z0-9_]*
        System.out.println("\\W: " + "加拿大@？《》".matches("\\W*"));
        // used to set the rules for password
        String pwRule = "[a-z]{1}\\w{3,7}";//start with a letter and length{4,8}
        String phoneNum = "[0-9]{3,4}-\\d{7,8}";
        System.out.println("phone num format: " + "954-5694527".matches(phoneNum));
    }
}
