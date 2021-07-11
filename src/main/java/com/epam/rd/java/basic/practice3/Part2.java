package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static int[] size = new int[2];

    public static void main(String[] args) {
        System.out.println(convert(Util.getInput("part2.txt")));
    }

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("[A-z]+");
        Matcher m = p.matcher(input);
        String[][] arr = new String[2][10];

        int max =0;
        int min = 100;
        while (m.find()) {
            if(m.group(0).length() <= min) {
                min =putInArray(m, arr[0], min, 0);
            }
            if(m.group(0).length() >= max){
                max =putInArray(m, arr[1], max, 1);
            }
        }

        return printConvetion(sb,arr,size[0],size[1]);
    }

    public static String printConvetion(StringBuilder sb, String[][] arr,int sizeMin,int sizeMax){
        sb.append("Min: ");
        for(int i =0; i<sizeMin;i++){
            sb.append(arr[0][i])
                    .append(", ");
        }
        sb.setLength(sb.length()-2);
        sb.append(System.lineSeparator());
        sb.append("Max: ");
        for(int i =0; i<sizeMax;i++){

            sb.append(arr[1][i])
                    .append(", ");
        }
        sb.setLength(sb.length()-2);
        return sb.toString();
    }

    public static int putInArray(Matcher m, String[] arr,int check,int switcher){
        if(m.group(0).length() == check){
            if(isUnique(arr,m.group(0),size[switcher])) {
                arr[size[switcher]] = m.group(0);
                size[switcher]++;
            }
        }
        else{
            clearArray(arr, size[switcher]);
            size[switcher] = 0;
            arr[size[switcher]] = m.group(0);
            size[switcher]++;
        }
        return m.group(0).length();
    }

    public static void clearArray(String[] arr, int size){
        for(int i=0; i<size; i++){
            arr[i] = null;
        }
    }

    public static boolean isUnique(String[] arr, String string,int size){
        try {
            for (int i=0; i< size; i++) {
                if (arr[i].equals(string)) {
                    return false;
                }
            }
            return true;
        }
        catch (NullPointerException exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
