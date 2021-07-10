package com.epam.rd.java.basic.practice3;

import java.util.Random;
import java.util.regex.*;

public class Part1 {

    public static void main(String[] args) {
        System.out.println(convert1(Util.getInput("part1.txt")));
        System.out.println();
        System.out.println(convert2(Util.getInput("part1.txt")));
        System.out.println();
        System.out.println(convert3(Util.getInput("part1.txt")));
        System.out.println();
        System.out.println(convert4(Util.getInput("part1.txt")));
    }

    public static String convert1(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("(?m)^(\\S*);(\\S* .\\S*);([a-z]*@([a-z]*.com))");
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
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("(?m)^(\\S*);(\\S*) (\\S*);([a-z]*@([a-z]*.com))");
        Matcher m = p.matcher(input);
        while (m.find()) {
            sb.append(m.group(3))
                    .append(" ")
                    .append(m.group(2))
                    .append(" (email: ")
                    .append(m.group(4))
                    .append(")")
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert3(String input) {
        final String arrow = " ==> ";
        StringBuilder sb = new StringBuilder();
        String[][] domainArr = new String[2][10];
        Pattern p = Pattern.compile("(?m)^(\\S*);(\\S* \\S*);([a-z]*@([a-z]*.com))");
        Matcher m = p.matcher(input);
        int i =0;
        while (m.find()){
            domainArr[0][i]=m.group(1);
            domainArr[1][i]=m.group(4);
            i++;
        }
        for(int k = 0; k < 2; k++) {
            sb.append(domainArr[1][k])
                    .append(arrow);
            for(int j =0; j< i; j++) {
               if(domainArr[1][j].equals(domainArr[1][k])){
                   sb.append(domainArr[0][j])
                           .append(", ");
               }
            }
            sb.setLength(sb.length() - 2);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert4(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("(?m)^(\\S*);(\\S* \\S*);([a-z]*@([a-z]*.com))");
        Random random = new Random();
        Matcher m = p.matcher(input);
        sb.append("Login;Name;Email;Password")
                .append(System.lineSeparator());
        while (m.find()){
            sb.append(m.group(0))
                    .append(";");
            for(int i=0; i<4;i++){
                sb.append(random.nextInt(9));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}