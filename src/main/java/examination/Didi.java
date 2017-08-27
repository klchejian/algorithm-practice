package main.java.examination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Didi {

    public static void main(String[] args){

        //45 67 33 21
//        2
//                /n
//        45
       fun2();

    }

    public static void fun1(){
        Scanner sc = new Scanner(System.in);
        int maxSum = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(sc.hasNextInt()){
            arr.add(sc.nextInt());
        }
        int n = arr.size();
        maxSum = arr.get(0);
        int[] maxArr = new int[n];
        maxArr[0] = maxSum;
        for(int i = 1 ; i < n; i++){
            if(maxArr[i-1] < 0){
                maxArr[i] = arr.get(i);
            }else{
                maxArr[i] = maxArr[i-1] + arr.get(i);
            }
            maxSum = Math.max(maxSum,maxArr[i]);
        }
        System.out.println(maxSum);
    }
    public static void fun2(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        while(sc.hasNextInt()){
            arr.add(sc.nextInt());
        }

        int k = arr.remove(arr.size() - 1);
        Collections.sort(arr,Collections.<Integer>reverseOrder());
        int i =1;
        for(Iterator<Integer> it = arr.iterator() ; i <= k && it.hasNext(); i++){
            if(i==k)
                System.out.print(it.next());
            else
                it.next();
        }


//        int n = arr.size() - 1;
//        int k = arr.get(n);
//        int[] maxArr = new int[k];
//        int i = 0;
//        int temp;
//        for(Iterator<Integer> it = arr.iterator() ; i < k && it.hasNext(); i++){
//            temp = it.next();
//            maxArr[i] = temp;
//            for(int j =  i-1 ; j >=0; j--){
//                if(maxArr[j] > maxArr[i]){
//                    maxArr[i] = maxArr[j];
//                    maxArr[j] = temp;
//                }
//            }
//        }
//
//        for(i = k; i < n ; i++){
//            if(arr.get(i))
//        }
//        System.out.println("N:"+ n);
//        System.out.println("K:"+ k);


    }
}
