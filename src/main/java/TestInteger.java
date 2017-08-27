package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by root on 8/16/17.
 */
public class TestInteger {
    public static void main(String[] args){
//        HashMap
       Hashtable<String,String> hm = new Hashtable<>();
       hm.put(null,"thenullkey");

//       System.out.println(hm.get(null));
//       hm.put(null,null);
//        System.out.println(hm.get(null));
//        hm.put("nullvalue",null);
        System.out.println(hm.get("nullvalue"));
        System.out.println(hm.get("chejian"));
        System.out.println(hm.containsKey("nullvalue"));
        System.out.println(hm.containsKey("chejian"));
//        Integer a = new Integer(12);
//        Integer b = new Integer(200);
//        Integer c = new Integer(200);
//        System.out.println(b == c);
//        Integer.parseInt("234");
//        System.out.println(testtry());
//        testBloolean();
    }

    public static void testLong(){
        System.out.println("LONG");
        for(long i = 120; i < 130; i++){
            Long L1 = i;
            Long L2 = i;
            long l1 = i;
            System.out.println(i);
            System.out.println(L1==L2);
            System.out.println(L1==l1);
        }
    }

    public static void testInteger(){
        for(int i = 120; i < 130; i++){
            Integer L1 = i;
            Integer L2 = i;
            int l1 = i;
            System.out.println(i);
            System.out.println(L1==L2);
            System.out.println(L1==l1);
        }
    }

    public static void testBloolean(){
        Boolean i1 = false;
        Boolean i2 = false;
        Boolean i3 = true;
        Boolean i4 = true;

        System.out.println(i1==i2);
        System.out.println(i3==i4);
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
