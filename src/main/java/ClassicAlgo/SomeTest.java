package main.java.ClassicAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by root on 8/6/17.
 */
public class SomeTest {
//    static int cc = 2;
    public static void main(String[] args) {
//        testAsList();
        passvalue();
    }

    private static void passvalue(){
        Dog d = new Dog("initdog");
        System.out.println(d.name);
        changeName(d);
        System.out.println(d.name);
        reNewDog(d);
        System.out.println(d.name);
    }

    public static class Dog{
        public String name;
        Dog(String name){
            this.name = name;
        }
    }

    public static void changeName(Dog d){
        d.name="name_changed";
    }

    public static void reNewDog(Dog d){
        d = new Dog("reinitdog");
    }

    private static void testAsList(){

        String[] a = {"c","5","j"};
        List<String> lista = Arrays.asList(a);
        List<String> listb = new ArrayList<String>();
//        ThreadPoolExecutor

//        lista.add("jian");
        listb.add("jian");
    }

    private void currupt(){
//        static int cc = 2;
        MyThread mt = new MyThread();
        mt.interrupt();

        MyRunnable mr = new MyRunnable();
        mt.yield();

        Thread t = new Thread();

    }

    private class MyThread extends Thread {

    }

    private class MyRunnable implements Runnable{
        public void run() {

        }
    }
}
