package main.java.examination;

import java.util.ArrayList;
import java.util.Scanner;

public class Huawei {

    public static void main(String[] args){
        fun2();
    }

    public static void test1(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] inputArr = input.toCharArray();
        StringBuilder res = new StringBuilder();
        if(inputArr.length > 20){
            System.out.println("ERROR!");
            return;
        }
        int i,j;
        for(i = 0; i < inputArr.length; i++){
            if(inputArr[i]<'0' || inputArr[i]>'9' || inputArr[i]<'a' || inputArr[i]>'z' || inputArr[i]<'A' || inputArr[i]>'Z'){
                System.out.println("ERROR!");
                return;
            }
            if(i%2 == 0){
                res.append(inputArr[i]);
            }

        }
        System.out.println(res.toString());
    }

    public static void test2(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] inputArr = input.toCharArray();
        int size = 1;
        int pos = -1;
        char temp;
        for(int i = 1; i < inputArr.length; i++){
            pos = -1;
            for(int j = 0 ; j < i; j++){
                if(inputArr[j]==inputArr[i]){
                    pos = j;
                }
                if(pos>=0 && inputArr[j]>inputArr[i]){
                    temp = inputArr[pos];
                    inputArr[pos] = inputArr[j];
                    inputArr[j] = temp;
                }
            }
            if(pos < 0){
                inputArr[size] = inputArr[i];
                size++;
            }
        }
        for(int i = 0; i < size; i++){
            System.out.print(inputArr[i]);
        }
    }

    public static void test3(){
        Scanner sc = new Scanner(System.in);
        int src = sc.nextInt();
        int des = sc.nextInt();
        char[] in = sc.nextLine().toCharArray();

        System.out.println(convert(src,des,in));
    }

    public static String convert(int src,int des,char[] num){
        int value = 0;
        for(int i =0; i< num.length; i++){
            value *= src;
            value += getValue(num[i]);
        }

        StringBuilder desNum = new StringBuilder("");
        while(value > 0){
            desNum.append(toValue(value%des));
            value /= des;
        }

        return desNum.toString();
    }

    public static int getValue(char c){
        if(c >= '0' && c <= '9'){
            return c - '0';
        }else if(c >= 'a' && c <= 'z'){
            return 10 + c - 'a';
        }else if(c >= 'A' && c <= 'z'){
            return 36 + c - 'A';
        }
        return 0;
    }
    public static char toValue(int num){
        // char tmp = '0';
        if(num < 10){
            return (char) (num + '0');
        }else if(num < 36){
            return (char) (num - 10 + 'a');
        }else {
            return (char) (num - 36 + 'A');
        }
    }


    public static void fun2(){
        String str1 = "1.1.1.1";
        String str2 = "255.255.255.255";
        String str3 = "2.2.2.2";
        String str4 = "3.3.3.3";

        String[] aStartStr = str1.split("\\.");
        int[] aStart = new int[aStartStr.length];
        for(int i = 0; i < 4; i++){
            aStart[i] = Integer.valueOf(aStartStr[i]);
        }
        String[] aEndStr = str2.split("\\.");
        int[] aEnd = new int[aEndStr.length];
        for(int i = 0; i < 4; i++){
            aEnd[i] = Integer.valueOf(aEndStr[i]);
        }
        String[] bStartStr = str3.split("\\.");
        int[] bStart = new int[bStartStr.length];
        for(int i = 0; i < 4; i++){
            bStart[i] = Integer.valueOf(bStartStr[i]);
        }
        String[] bEndStr = str4.split("\\.");
        int[] bEnd = new int[bEndStr.length];
        for(int i = 0; i < 4; i++){
            bEnd[i] = Integer.valueOf(bEndStr[i]);
        }


        boolean flag = true;
        for(int i  = 0; i < 4; i++){
            if(aEnd[i]>bStart[i]){
                break;
            }else if(aEnd[i]<bStart[i]){
                System.out.println("No Overlap IP");
                return;
            }
        }

        for(int i  = 0; i < 4; i++){
            if(bEnd[i]>aStart[i]){
                break;
            }else if(bEnd[i]<aStart[i]){
                System.out.println("No Overlap IP");
                return;
            }
        }

        System.out.println("Overlap IP");

    }



    public static void fun3(int m){

//        String str = "1223 22 3232 2016";
//        int k = m;

       Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        String[] strArr = str.split(" ");
        int n = strArr.length;
        int[] res = new int [k];
        int[] intArr = new int[strArr.length];
        for(int i = 0;  i < n; i++){
            int temp = Integer.valueOf(strArr[i])%1000;
            intArr[i] = temp;
        }
        int minValue = Integer.MAX_VALUE;
        ArrayList<Integer> minValueIndex = new ArrayList<>();
        for(int j = 0; j < k;) {
            for (int i = 0; i < n; i++) {
                if(intArr[i] < 0)
                    continue;
                if (intArr[i] < minValue) {
                    minValue = intArr[i];
                    minValueIndex.clear();
                    minValueIndex.add(i);
                }else if(intArr[i] == minValue){
                    minValueIndex.add(i);
                }
            }
            for(int i = 0; i < minValueIndex.size(); i++){
                if(j<k){
                    res[j] = minValueIndex.get(i);
                    intArr[minValueIndex.get(i)] = -1;
                    j++;
                }else
                    break;
            }
            minValue = Integer.MAX_VALUE;
            minValueIndex.clear();
        }
        System.out.println(strArr[res[res.length - 1]]);
    }
}
