package main.java.sort;

import java.util.Random;

/**
 * Created by root on 8/7/17.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] input = AllSort.generate(10);
        AllSort.printArray(input);
        quickSort2(input,0,input.length-1);
        AllSort.printArray(input);
    }

    public static void quickSort1(int[] input, int l, int r){
        if(l<r){
            int i = l,j = r, x = input[l];
            while(i<j){
                while(i < j && input[j] >= x){
                    j--;
                }
                if(i<j){
                    input[i++] = input[j];
                }

                while(i < j && input[i] <x){
                    i++;
                }
                if(i<j){
                    input[j--] = input[i];
                }
            }
            input[i] = x;
            quickSort1(input,l,i-1);
            quickSort1(input,i+1,r);
        }

    }

    public static void quickSort2(int[] input, int l, int r){
        if(l<r) {
            int tmp = input[l];
            int i = l, j = r;
            while (i < j) {
                while (i < j && input[j] >= tmp) {
                    j--;
                }
                if (i < j) {
                    input[i++] = input[j];
                }

                while (i < j && input[i] < tmp) {
                    i++;
                }
                if (i < j) {
                    input[j--] = input[i];
                }

            }
            input[i] = tmp;
            quickSort2(input, l, i - 1);
            quickSort2(input, i+1, r);

        }
    }
}
