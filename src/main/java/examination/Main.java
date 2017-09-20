package main.java.examination;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        fun3();

    }

    public static void fun3(){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//
//        int[] x = new int[n];
//        int[] y = new int[n];
        int[]x = {0,-1,1,1,-1};
        int[]y = {0,-1,-1,1,1};
        int n = y.length;
        int[] fla = new int[n];
        int zeroPos = 0;
        int lineNum = 0;
        int res = 0;
//        for(int i = 0; i < n; i++){
//            x[i] = in.nextInt();
//        }
//        for(int i = 0; i < n; i++){
//            y[i] = in.nextInt();
//        }

        for(int i = 0; i < n && fla[i]==0; i++){

            if(x[i]==0 && y[i]==0){
                zeroPos = 1;
                continue;
            }else if(x[i]==0 || y[i]==0){
                lineNum++;
                continue;
            }else{
                int tmpRes = 0;
                for(int j = i+1; j < n; j++){

                    if(x[i]==x[j] && y[i]==y[j]){
                        tmpRes++;
                        fla[j]=1;
                    }else if(x[i]*y[i]>0 && x[j]*y[j]>0 &&    Math.abs(x[i])==Math.abs(y[i]) && Math.abs(x[j])==Math.abs(y[j])     ){
                        tmpRes++;
                        fla[j]=1;
                    }else if(x[i]*y[i]<0 && x[j]*y[j]<0 &&    Math.abs(x[i])==Math.abs(y[i]) && Math.abs(x[j])==Math.abs(y[j])     ){
                        tmpRes++;
                        fla[j]=1;
                    }else if(  (x[i]==-y[i] && x[j]==-y[j])   || (x[i]==x[j] && y[i]==-y[j]) || (y[i]==y[j] && x[i]==-x[j])     ){
                        tmpRes++;
                        fla[j]=1;
                    }
                }
                res = Math.max(res,tmpRes)+1;
            }

        }
        res = Math.max(res,lineNum)+zeroPos;

        System.out.println(res);
    }

    public static void fun1() {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] input = new int[n];
//        for (int i = 0; i < n; i++){
//            input[i] = sc.nextInt();
//        }
//        int k = sc.nextInt();

        int n = 6;
        int k = 4;
        int[] input = {3, 1, 2, 7, 7, 7};

        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {

            if (n - i < res)
                break;
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += input[j];
                if (sum % k == 0)
                    res = Math.max(j - i + 1, res);
            }
        }
        System.out.println(res);
    }

    public static void fun2() {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] input = new int[n];
//        for (int i = 0; i < n; i++){
//            input[i] = sc.nextInt();
//        }
        int n = 6;
        int k = 4;
        int[] input = {3, 1, 2, 7, 7, 7};
        if (n <= 1) {
            System.out.println("No");
            return;
        }
        Arrays.sort(input);
        int countNum = input[n - 1];
        int initGroupNum = input[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (countNum < input[i]) {
                System.out.println("No");
                return;
            }
            initGroupNum -= input[i];
            if (i == 0 && initGroupNum > 0) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}