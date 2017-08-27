package main.java;

public class StringEqualTest {
    public static void main(String[] args) {
//        String s1 = "Programming";
//        String s2 = new String("Programming");
//        String s3 = "Program" + "ming";
////        System.out.println(s1 == s2);
////        System.out.println(s1 == s3);
////        System.out.println(s1 == s3.intern());
//        System.out.println(s2 == s2.intern());
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern()==str1);
//
//
//        String str2 = new StringBuilder("ja").append("va2").toString();
//        System.out.println(str2.intern()==str2);

        String str1 ="a";
        String str2 = "b";
        String str3 = str1+str2;
        System.out.println(str3.intern()==str3);


    }
}
