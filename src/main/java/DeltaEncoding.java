package main.java;

/**
 * Created by root on 8/6/17.
 */
public class DeltaEncoding {

    public static void main(String[] args) {
        String str = "chejian8";
        char[] strarry = str.toCharArray();
        printChar(strarry);
        delta_encode(strarry, strarry.length);
        printChar(strarry);
        delta_decode(strarry,strarry.length);
        printChar(strarry);

    }

    private static void delta_encode(char[] buf, int n) {
        char last = 0;
        for(int i = 0; i < n; i++){
            char current = buf[i];
            buf[i] = (char)(current-last);
            last = current;
        }
    }

    private static void delta_decode(char[] buf, int n) {
        char last = 0;
        for(int i = 0; i < n; i++) {
            char delta = buf[i];
            buf[i] = (char)(delta + last);
            last = buf[i];
        }
    }

    private static void printChar(char[] buf){
        for(int i = 0 ; i < buf.length ; i++){
            System.out.print(buf[i]);
        }
        System.out.println();
    }
}
