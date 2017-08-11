package main.java.ClassicAlgo;

import java.util.Scanner;

/**
 * Created by root on 8/9/17.
 */
public class BcdCode {

    public static void main(String[] args) {
//        0x31,0x16,0x49,0x32,0x44,0xF4
//        13619423444
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strArr = str.split(",");
        String result = bcdToString(strArr);
        System.out.println(result);
    }

    public static String bcdToString(String[] str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length; i++)
            if(str[i].length() != 4)
                System.out.print("error");
        for(int i=0; i<str.length; i++){
            char[] c = str[i].toCharArray();
            for(int j=3; j>=2; j--){
                if(c[j] >= '0' && c[j]<='9')
                    sb.append(c[j]);
            }
        }
        return sb.toString();
    }


    public static String testbcd(String temp){
        return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp.toString().substring(1) : temp.toString();
    }

    /**
     * @??: BCD???10???(?????)
     * @??: BCD?
     * @??: 10???
     */
    public static String bcd2Str(byte[] bytes) {
        StringBuffer temp = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
            temp.append((byte) (bytes[i] & 0x0f));
        }
        return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp
                .toString().substring(1) : temp.toString();
    }

    /**
     * @??: 10?????BCD?
     * @??: 10???
     * @??: BCD?
     */
    public static byte[] str2Bcd(String asc) {
        int len = asc.length();
        int mod = len % 2;
        if (mod != 0) {
            asc = "0" + asc;
            len = asc.length();
        }
        byte abt[] = new byte[len];
        if (len >= 2) {
            len = len / 2;
        }
        byte bbt[] = new byte[len];
        abt = asc.getBytes();
        int j, k;
        for (int p = 0; p < asc.length() / 2; p++) {
            if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
                j = abt[2 * p] - '0';
            } else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
                j = abt[2 * p] - 'a' + 0x0a;
            } else {
                j = abt[2 * p] - 'A' + 0x0a;
            }
            if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
                k = abt[2 * p + 1] - '0';
            } else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
                k = abt[2 * p + 1] - 'a' + 0x0a;
            } else {
                k = abt[2 * p + 1] - 'A' + 0x0a;
            }
            int a = (j << 4) + k;
            byte b = (byte) a;
            bbt[p] = b;
        }
        return bbt;
    }

}
