package com.epam.rd.java.basic.practice3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;



public class Part1 {

    public static final String ENCODING = "UTF-8";

    public static void main(String[] args) {
        System.out.println(convert1(Util.getInput("part1.txt")));
    }

    public static String convert1(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("(?m)^(\\S*);.*;([a-z]*@[a-z]*.com)");
        Matcher m = p.matcher(input);
        while (m.find()) {
            sb.append(m.group(1))
                    .append(": ")
                    .append(m.group(3))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert2(String input) {
        return null;
    }

    public static String convert3(String input) {
        return null;
    }

    public static String convert4(String input) {
        return null;
    }
}