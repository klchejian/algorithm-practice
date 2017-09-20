package main.java.examination;

import java.util.Scanner;

public class MeiTuan {
    public static void main(String[] args) {
        subSeven();
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Long.MAX_VALUE);

    }


    public static void subSeven() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        int count = 0;

        for(int i = 0;i<n;i++){
            long tmp = a[i]%7;
            for(int j = 0; j < n; j++){
                if(i == j)
                    continue;
                int length = String.valueOf(a[j]).length();
                long res = tmp*(long)Math.pow(10,length)+a[j];
                if(res%7 == 0)
                    count++;
            }
        }
        System.out.println(count);
    }


    public static void subSeven2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        int count = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0; j < n; j++){
                if(i == j)
                    continue;
                int length = String.valueOf(a[j]).length();
                long res = a[i]*(long)Math.pow(10,length)+a[j];
                if(res%7 == 0)
                    count++;
            }
        }
        System.out.println(count);
    }

}
