package main.java.sort;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by root on 8/1/17.
 */
public class ShellSort {
    public static void main(String[] args){
        int[] input = new int[10];
        Random r = new Random();
        for(int i = 0 ; i < input.length ; i ++){
            input[i] = r.nextInt(10);
        }
        AllSort.printArray(input);
        shellSortOptimized(input,input.length);
        AllSort.printArray(input);

    }

    public static void shellSort1(int[] input, int n) {

        for(int gap = n/2;gap>0;gap = gap/2){

            for(int i=0;i<gap;i++){

                for(int j = i+gap; j < n; j+=gap) {

//                    int tmp = input[j];
                    int k;
                    for(k=j-gap; k>=0; k = k-gap){
                        if(input[k]>input[j]){
                            int tmp = input[k];
                            input[k] = input[k+gap];
                            input[k+gap] = tmp;
                        }else if(input[k] < input[j]){
                            input[k+gap] = input[j];
                            break;
                        }
                    }
//                    if()
                }
            }

        }
    }


    public static void shellSortOptimized(int[] input, int n) {
        int gap,i,j,k;
        for(gap = n/2; gap>0 ; gap /=2){
            for(i = gap; i < n ; i++){
                for(j = i-gap; j>=0 && input[j+gap] < input[j]; j-=gap){
                    AllSort.swap(input,j,j+gap);
                }
            }
        }
    }


}
