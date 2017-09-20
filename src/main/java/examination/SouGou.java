package main.java.examination;

import java.util.Arrays;
import java.util.Random;

public class SouGou {
    public static void main(String[] args){
        for(int i = 0; i < 100;i++){
            fun1();
        }
    }

    public static void fun1(){
        int n = 1;
        Random r = new Random();
        double[] input = new double[n];
        for(int i = 0; i < n; i++){
            double tmp = r.nextInt(360);

            input[i] = tmp;
        }
        Arrays.sort(input);
        System.out.println(Arrays.toString(input));
        int start = 0;
        int end = 1;
        double max = 0;

//        while(end < n){
//            boolean bl= false;
//            double delta = input[end]-input[start];
//            if(delta>180) {
//                delta = delta - 180;
//                bl = true;
//            }
//            if(Math.sin(delta) >= 0){
//                if(bl) {
//                    Math.max(360 - (input[end] - input[start]), max);
//                } else {
//                    max = Math.max(input[end] - input[start], max);
//                }
//                end++;
//            }else{
//                start++;
//            }
//        }

        while(end < n){
            double result = input[end] - input[start];
            if(result > 180){
                max = Math.max(max,360-(input[end]-input[start]));
                start++;
            }else{
                max = Math.max(max,input[end]-input[start]);
                end++;
            }
        }
        System.out.println(max);

        double max2 = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1; j < n ; j++){
                double tmp = input[j] - input[i];
                if(tmp>180){
                    tmp = 360-tmp;
                }
                max2 = Math.max(tmp,max2);
            }
        }
        System.out.println(max2);
        if(max==max2){
            System.out.println("success");

        }else{
            System.out.println("-----------FAILED--------------");
        }
    }
}
