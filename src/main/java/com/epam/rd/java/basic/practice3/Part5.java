package com.epam.rd.java.basic.practice3;

enum ROMAN{
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    END(9999999);

    private final int value;

    ROMAN(int  value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}

public class Part5 {

    public static void main(String[] args) {
        System.out.println(decimal2Roman(45));
        System.out.println(roman2Decimal(decimal2Roman(45)));
    }

    public static String decimal2Roman(int dec) {
        StringBuilder sb = new StringBuilder();
        ROMAN temp = ROMAN.I;
        ROMAN index = ROMAN.I;
        while (dec !=0) {
            for (ROMAN number : ROMAN.values()) {
                if(number.getValue()> 10){
                    index = ROMAN.X;
                }
                if (dec >= number.getValue()) {
                    temp = number;
                }
                else {
                    if (number.getValue() - index.getValue() == (dec / 10) * 10 || number.getValue() - index.getValue() == dec % 10) {
                        sb.append(index)
                                .append(number);
                        dec -= number.getValue() - index.getValue();

                    }
                    else {
                        dec -= temp.getValue();
                        sb.append(temp);
                    }
                    break;
                }
            }
            index = ROMAN.I;
        }

        return sb.toString();
    }

    public static int roman2Decimal(String roman) {
        StringBuilder sb = new StringBuilder(roman);
        sb.reverse();
        char[] chars = sb.toString().toCharArray();
        int temp=0;
        int summ=0;
        for(char ch : chars){

            if(ROMAN.valueOf(Character.toString(ch)).getValue() < temp){
                summ -= ROMAN.valueOf(Character.toString(ch)).getValue();
                continue;
            }
            summ += ROMAN.valueOf(Character.toString(ch)).getValue();
            temp = ROMAN.valueOf(Character.toString(ch)).getValue();
        }
        return summ;
    }
}
