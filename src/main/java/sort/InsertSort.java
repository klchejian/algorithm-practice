package main.java.sort;

import java.util.Random;

/**
 * Created by root on 8/1/17.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] input = new int[10];
        Random r = new Random();
        for(int i = 0 ; i < input.length ; i++){
            input[i] = r.nextInt(100);
        }
        AllSort.printArray(input);
        insertSort1(input,input.length);
        AllSort.printArray(input);


    }

    public static void insertSort1(int[] input, int n) {
        int i,k;
        for(i=1; i < input.length; i++) {
            for(k = i -1; k>=0 && input[k]>input[k+1]; k --){
                AllSort.swap(input,k+1,k);
            }
        }
    }
}
