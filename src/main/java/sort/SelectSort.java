package main.java.sort;

import java.util.Random;

/**
 * Created by root on 8/1/17.
 */
public class SelectSort {
    public static void main(String[] args){
        int[] input = new int[10];
        Random r = new Random();
        for(int i = 0 ; i < input.length ; i ++){
            input[i] = r.nextInt(10);
        }
//        System.out.println("-----SelectSort-----");
//        AllSort.printArray(input);
//        selectSort(input,input.length);
//        AllSort.printArray(input);
        int[] test = new int[2];
        test[0] = 2;
        test[1] = 5;
        AllSort.printArray(test);
        swaptest(test,0,1);
        AllSort.printArray(test);


    }

    public static void selectSort(int[] input, int n){
        int i,j,k;
        for(i = 0 ; i < n; i++){
            k = i;
            for(j = i; j < n; j++){
                if(input[j]<input[k]){
                    k = j;
                }
            }
            AllSort.swap(input,k,i);
        }
    }

    private static void swaptest(int[] input, int a, int b){
        input[a] ^= input[b];
        input[b] ^= input[a];
        input[a] ^= input[b];
    }

}
