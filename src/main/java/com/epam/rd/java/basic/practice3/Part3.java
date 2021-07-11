package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void main(String[] args) {
        System.out.println();
        System.out.println(convert(Util.getInput("part3.txt")));
    }

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("([A-ZА-Я])([a-zа-я]{3,})|([a-zа-я])([a-zа-я]{2,})|(\\s)+|([A-ZА-Яa-zа-я]+){0,2}");
        Matcher m = p.matcher(input);
        while (m.find()){
            if(m.group(1)!= null){
                sb.append(Character.toLowerCase(m.group(1).toCharArray()[0]))
                        .append(m.group(2));
            }
            if(m.group(3) != null){
                sb.append(Character.toUpperCase(m.group(3).toCharArray()[0]))
                        .append(m.group(4));
            }
            if(m.group(5) != null){
                sb.append(m.group(5));
            }
            if(m.group(6) != null){
                sb.append(m.group(6));
            }
        }
        return sb.toString();
    }
}
