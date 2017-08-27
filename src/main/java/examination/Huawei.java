package main.java.examination;

import java.util.Scanner;

public class Huawei {

    public static void main(String[] args){
        test1();
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
}
