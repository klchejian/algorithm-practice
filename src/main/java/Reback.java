package main.java;

import java.util.LinkedList;
import java.util.Scanner;
/**
 * Created by root on 8/12/17.
 */
public class Reback {
    LinkedList<Integer> list = new LinkedList<>();

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] input = new int[n];
//        int times = 0;
//        for(int i = 0; i < n; i++){
//            input[i] = sc.nextInt();
//        }
//        int i = 0, j = n - 1;
//        while(i < j){
//            if(input[i] < input[j]){
//                times ++;
//                input[++i] += input[i-1];
//            }else if(input[i] > input[j]){
//                times ++;
//                input[--j] += input[j+1];
//            }else{
//                i++;
//                j--;
//            }
//        }
//        System.out.println(times);
//    }

//        public static void main(String[] args){
////            Scanner sc = new Scanner(System.in);
////            int input = sc.nextInt();
//            int input = 25;
//            int res = 0;
//            for(int i = 0; i*i <= input; i++){
//                for(int j = 0; (j*j+i*i) <= input; j++){
//                    if( (j*j+i*i) == input){
//                        if (i > 0 && j > 0) {
//                            res += 4;
//                        }
//                    }
//                }
//            }
//            System.out.println(res);
//        }

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
        int a = 123;
        int b = 100;
        System.out.println(rev(123));
//        System.out.println(rev(rev(a) + rev(b)));
    }

    public static int rev(int num){
        int length = String.valueOf(num).length();
        int tmp = 0;
        int res = 0;
        for(int i = 0; i < length; i++){
            tmp = num%10;
            num /=10;
            res += (length-i-1)>0 ? tmp*(length-i-1):tmp;
        }
        Math.sqrt(4);
        return res;
    }



}
