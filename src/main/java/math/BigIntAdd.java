package main.java.math;

import java.util.Random;

/**
 * Created by root on 8/5/17.
 */
public class BigIntAdd {

    public static void main(String[] args) {
        Random r = new Random();
        int a = r.nextInt(100);
        int b = r.nextInt(100);
        System.out.println(a+b);
        System.out.println(add(String.valueOf(a),String.valueOf(b)));

    }

    private static String add(String a, String b){
        int lengtha = a.length();
        int lengthb = b.length();
        int length = 1 + Math.max(a.length(), b.length());
        for(int i = 0; i < (length-lengtha); i++) {
            a = "0"+a;
        }
        for(int i = 0; i < (length-lengthb); i++) {
            b = "0"+b;
        }

        char[] numa = a.toCharArray();
        char[] numb = b.toCharArray();



        int[] result = new int[length];
        int carry = 0;
        for(int i = length - 1 ; i >= 0; i--){
            try {
                int tmp = Integer.valueOf(String.valueOf(numa[i])) + Integer.valueOf(String.valueOf(numb[i])) + carry;
                carry = tmp/10;
                result[i] = tmp%10;
            }catch (Exception e ){
                e.printStackTrace();
            }
        }

        int pos = 0;
        for(int i = 0 ; i < result.length; i++){
            if(i!=0){
                pos = i;
                break;
            }
        }

        StringBuffer restr = new StringBuffer("");
        for(;pos < result.length; pos++){
            restr.append(result[pos]);
        }

        return restr.toString();


//        return new String("0");
    }
}
