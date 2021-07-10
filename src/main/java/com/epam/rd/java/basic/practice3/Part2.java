package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) {
        System.out.println(convert(Util.getInput("part2.txt")));
    }

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("[А-яA-z]+");
        Matcher m = p.matcher(input);
        String[][] arr = new String[2][10];

        int max =0;
        int min = 100;
        int sizeMin =0;
        int sizeMax = 0;
        while (m.find()) {
            if(m.group(0).length() <= min){
                min = m.group(0).length();
                if(m.group(0).length() == min){
                    if(isUnique(arr[0],m.group(0))) {
                        arr[0][sizeMin] = m.group(0);
                        sizeMin++;
                    }
                }
            }
            if(m.group(0).length() >= max){
                max = m.group(0).length();
                if(m.group(0).length() == max){
                    if(isUnique(arr[1], m.group(0))){
                        arr[1][sizeMax] = m.group(0);
                        sizeMax++;
                    }
                }
            }
        }

        return printConvetion(sb,arr,sizeMin,sizeMax);
    }

    public static String printConvetion(StringBuilder sb, String[][] arr,int sizeMin,int sizeMax){
        sb.append("Min: ");
        for(int i =0; i<sizeMin;i++){
            sb.append(arr[0][i])
                    .append(", ");
        }
        sb.setLength(sb.length()-2);
        sb.append(System.lineSeparator());
        for(int i =0; i<sizeMax;i++){
            sb.append(arr[1][i])
                    .append(", ");
        }
        sb.setLength(sb.length()-2);
        return sb.toString();
    }

    public static boolean isUnique(String[] arr, String string){
        for(String s : arr){
            if(s.equals(string)){
                return false;
            }
        }
        return true;
    }
}
