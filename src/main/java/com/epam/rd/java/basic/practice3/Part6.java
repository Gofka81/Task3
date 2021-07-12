package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
        System.out.println(convert(Util.getInput("part6.txt")));
    }

    public static String convert(String input) {
        String[] buffer = new String[50];
        String[] copy = new String[50];
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("([\\S]*)(\\s)*");
        Matcher m = p.matcher(input);
        int size =0;
        int copySize =0;
        while (m.find()){
            if(size ==0){
                buffer[size] = m.group(1);
                size++;
                continue;
            }
            if(isUnique(m.group(1), buffer, size)&& m.group(1)!=null){
                buffer[size] = m.group(1);
                size++;
            }
            else {
                if (m.group(1)!=null) {
                    copy[copySize] = m.group(1);
                    copySize++;
                }
            }
        }
        m = p.matcher(input);
        while (m.find()){
            if(!m.group(1).equals("")){
                if(isUnique(m.group(1),copy,copySize)) {
                    sb.append(m.group(1));
                }
                else{
                    sb.append("_")
                            .append(m.group(1));
                }
            }
            if(m.group(2) == null){
                continue;
            }
            if(!m.group(2).equals("")){
                sb.append(m.group(2));
            }
        }
        return sb.toString();
    }

    private static boolean isUnique(String group,String[] buffer, int size) {
        boolean isUnique = true;
        for(int i=0; i< size; i++){
            if(buffer[i].equals(group)){
                isUnique = false;
                break;
            }
        }
        return isUnique;
    }

}
