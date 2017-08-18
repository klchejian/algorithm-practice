package main.java;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by root on 8/16/17.
 */
public class TestInteger {
    public static void main(String[] args){
//        Integer a = new Integer(12);
//        Integer b = new Integer(200);
//        Integer c = new Integer(200);
//        System.out.println(b == c);
//        Integer.parseInt("234");
        System.out.println(testtry());

    }

    public static int testtry(){
        int a = 0;
//        ConcurrentHashMap
        try{
            a = 1;
            int b;
            return a;
        }finally{
            a = 2;
//            b=1;
            return a;
        }
    }
}
