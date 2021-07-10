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
        Pattern p = Pattern.compile("(?m)^(\\S*);(\\S*) (\\S*);([\\S]*@([\\S]*.com))");
        Matcher m = p.matcher(input);
        while (m.find()) {
            sb.append(m.group(1))
                    .append(": ")
                    .append(m.group(4))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert2(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("(?m)^(\\S*);(\\S*) (\\S*);([\\S]*@([\\S]*.com))");
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
        StringBuilder sb = new StringBuilder();
        String[][] domainArr = new String[2][10];
        Pattern p = Pattern.compile("(?m)^(\\S*);(\\S*) (\\S*);([\\S]*@([\\S]*.com))");
        Matcher m = p.matcher(input);
        int size =0;
        while (m.find()){
            domainArr[0][size] = m.group(1);
            domainArr[1][size] = m.group(5);
            size++;
        }

        return printDomains(sb,domainArr,size);
    }

    public static String printDomains(StringBuilder sb, String[][] domainArr, int size){
        final String arrow = " ==> ";
        int sizeChek =size;
        for(int i =0; i<size-1; i++){
            if(sizeChek == 0){
                break;
            }
            sizeChek--;
            sb.append(domainArr[1][i])
                    .append(arrow)
                    .append(domainArr[0][i]);

            for(int j=i+1; j<size; j++){
                if(domainArr[1][i].equals(domainArr[1][j])){
                    sb.append(", ")
                            .append(domainArr[0][j]);
                    sizeChek--;
                    if(sizeChek == 0){
                        break;
                    }
                }
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert4(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("(?m)^(\\S*);(\\S*) (\\S*);([\\S]*@([\\S]*.com))");
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