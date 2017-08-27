package main.java.examination;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Test360 {
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] input = new int[n];
       int[] result = new int[n];
       for(int i = 0; i < n; i++){
            input[i] = sc.nextInt();
       }

       result[0] = 0;
       for(int i = 1 ; i <n ; i++){
           for(int j = i-1; j>=0;j--){
               if(input[i] < input[j]){
                   result[i]++;
               }
           }
       }
       System.out.println(Arrays.toString(result));
    }
}
