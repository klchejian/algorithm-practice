package main.java.sort;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Random;

/**
 * Created by root on 8/1/17.
 */
public class BubbleSort {

    public static void bubbleSort2(int a[], int n) {
        int i,j;
    }

    public static void bubbleSort1(int a[], int n) {
        int i, j;
        for (i = 0; i < n - 1; i++) {
            for (j = i+1; j < n; j++) {
                if (a[i] > a[j]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] input = new int[10];
        Random r = new Random(10);
        for (int i = 0; i < input.length; i++) {
            input[i] = r.nextInt(100);
            System.out.print(input[i] + "==");
        }
        System.out.println();
        bubbleSort1(input,input.length);

        for (int i = 0; i < input.length; i++) {
//            input[i] = r.nextInt();
            System.out.print(input[i] + "-");
        }

    }
}
