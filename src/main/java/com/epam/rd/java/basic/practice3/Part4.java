package com.epam.rd.java.basic.practice3;

import java.security.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("password", "MD5"));
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        return toHash(toBinary(hash));
    }

    public static String toBinary( byte[] bytes )
    {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for( int i = 0; i < Byte.SIZE * bytes.length; i++ )
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        return sb.toString();
    }

    public  static String toHash(String binary){
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("([0-1]{0,4})");
        Matcher m = p.matcher(binary);
        while (m.find()){
            int decimal = Integer.parseInt(m.group(1),2);
           sb.append(Integer.toString(decimal,16).toUpperCase());
        }
        System.out.println(sb);
        return sb.toString();
    }
}
