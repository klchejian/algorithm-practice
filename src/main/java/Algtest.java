package main.java;

import java.util.Scanner;

/**
 * Created by root on 8/9/17.
 */
public class Algtest {


    public static void main(String[] args) {
        byte[] input = new byte[6];
        input[0] = 0x31;
        input[1] = 0x16;
        input[2] = 0x49;
        input[3] = 0x32;
        input[4] = 0x44;
        input[5] = 0x4;
//        System.out.println(bcd2Str(input));
//        System.out.println(decode("3abb4cd"));
        Scanner sc = new Scanner(System.in);
        System.out.println(decode(sc.nextLine()));
    }

    public static String bcd2Str(byte[] bytes){
        StringBuilder temp = new StringBuilder(bytes.length * 2);

        for (int i = 0; i < bytes.length; i++)
        {
            temp.append((byte)((bytes[i] & 0xf0) >> 4));
            temp.append((byte)(bytes[i] & 0x0f));
        }
        return temp.toString().substring(0, 1).equals("0") ? temp.toString().substring(1) : temp.toString();
    }



    public static String decode(String inputStr) {
        if(inputStr == null || inputStr.length() <= 1) {
            return inputStr;
        }

        int len = inputStr.length();
        StringBuilder resultBuilder = new StringBuilder();
        for(int i = 0; i < len; i++) {
            char curChar = inputStr.charAt(i);
            if(Character.isDigit(curChar)) {
                i++;
                char nextChar = inputStr.charAt(i);
                int runLength = Integer.parseInt(curChar + "");
                for(int j = 0; j < runLength; j++) {
                    resultBuilder.append(nextChar);
                }
            }
            else {
                resultBuilder.append(curChar);
            }
        }

        return resultBuilder.toString();
    }
}
