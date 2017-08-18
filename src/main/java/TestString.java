package main.java;

/**
 * Created by root on 8/16/17.
 */
public class TestString {

    public static void main(String[] args) {
        try {
            int count = 50000;

            long begin = System.currentTimeMillis();
            testString(count);
            long end = System.currentTimeMillis();
            long time = end - begin;
            System.out.println("String "+count+":  " + time + "");

            begin = System.currentTimeMillis();
            testStringBuilder(count);
            end = System.currentTimeMillis();
            time = end - begin;
            System.out.println("StringBuilder "+count+":  " + time + "");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String testString(int count) {
        String result = "";

        for (int i = 0; i < count; i++) {
            result += "hello ";
        }

        return result;
    }

    private static String testStringBuilder(int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append("hello");
        }

        return sb.toString();
    }

}
