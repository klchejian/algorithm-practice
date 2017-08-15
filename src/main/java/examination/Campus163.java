package main.java.examination;

import java.util.Scanner;

/**
 * Created by root on 8/12/17.
 */
public class Campus163 {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        for(int i = 0; i < n; i++){
//            a[i] = sc.nextInt();
//        }
//        String res = "";
//        for(int i = 0; i < n; i++){
//            if(n%2 == 0){
//                if( i%2 > 0){
//                    res = res + " " + a[i];
//                }else{
//                    res = a[i] + " " + res;
//                }
//            }else{
//                if( i%2 > 0){
//                    res = a[i] + " " + res;
//                }else{
//                    res = res + " " + a[i];
//                }
//            }
//        }
//        System.out.println(res);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int temp = 0;
//        int j = 0;
        double count = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            count += arr[i];
            for(int j = i; j >0 && arr[j-1]>arr[j]; j--){
                temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }

        }
        count /= n;
        int i = 0;
        int j = n - 1;
        int a = 0;
        int b = 0;
        boolean flag = false;
        int result = 0;
        if( (count - (double)arr[0]) < ((double)arr[n-1] - count) ){
            flag = true;
            a = b = n - 1;
            j--;
        }else {
            flag = false;
            a = b = 0;
            i ++;
        }

        int temp1,temp2;
        while(i<j){
            if(flag){
                temp1 = result + (arr[a]-arr[i]) + (arr[b] - arr[i+1]);
                temp2 = result + (arr[a]-arr[i+1]) + (arr[b] - arr[i]);
                result = temp1>temp2?temp1:temp2;
                a=i;
                b=i+1;
                i += 2;
                flag = false;
            }else{
                temp1 = result + (arr[j] - arr[a]) + (arr[j-1] - arr[b]);
                temp2 = result + (arr[j-1] - arr[a]) + (arr[j] - arr[b]);
                result = temp1>temp2?temp1:temp2;
                a = j;
                b= j-1;
                j -= 2;
                flag = true;
            }
        }
        System.out.println(result);

    }
}
