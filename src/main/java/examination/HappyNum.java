package main.java.examination;

import java.util.HashSet;
import java.util.Scanner;

public class HappyNum {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n = 1;
        int sum = 0;
        for(int i = 0; i <= n; i++){
            sum += isHappy(i)?i:0;
        }
        System.out.println(sum);
    }

    public static boolean isHappy(int n) {

        int temp = n;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(temp);
        while (true) {
            temp = getNext(temp);
            if (temp == 1) {
                return true;
            } else if (hashSet.contains(temp)) {
                return false;
            }
            hashSet.add(temp);
        }
    }

    private static int getNext(int num) {
        int result = 0;
        while (num > 0) {
            result += (num % 10) * (num % 10);
            num = num / 10;
        }
        return result;
    }
}
