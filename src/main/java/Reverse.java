package main.java;

/**
 * Created by root on 8/16/17.
 */
public class Reverse {
    public static void main(String[] args){
        String input = "asdfg";
        System.out.println(input);
        System.out.println(reverse(input));
    }

    public static String reverse(String input){
        if(input == null || input.length()<=1){
            return input;
        }
        return reverse(input.substring(1)) + input.charAt(0);
    }
}
