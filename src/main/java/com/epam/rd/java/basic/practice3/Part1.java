package com.epam.rd.java.basic.practice3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;



public class Part1 {

    public static final String ENCODING = "UTF-8";

    public static void main(String[] args) {
        String string = getData();
        System.out.println(convert1(string));
    }

    public static String convert1(String input) {
        String[] sentence = splitToSentence(input);
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("(\\S*);.*;([a-z]*@[a-z]*.com)");
        for(String s: sentence) {
            Matcher m = p.matcher(s);
            while (m.find()){
                sb.append(m.group(1)).append(": ").append(m.group(2)).append("\r\n");
            }
        }
        return sb.toString().trim();
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

    public static String getData(){
        StringBuilder string = new StringBuilder();
        try(Scanner scanner = new Scanner(new File("part1.txt"),ENCODING)){
            scanner.nextLine();
            while(scanner.hasNextLine()){
                string.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return string.toString().trim();
        }
        catch (FileNotFoundException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static String[] splitToSentence(String string){
        return string.split("\r\n");
    }
}