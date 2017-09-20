package main.java.examination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Tencent {
    public static void main(String[] args) {
        fun3();
        String a = "abcchejian";
        a.replace("che","ss");
        System.out.println(a);

    }
    public static void fun1(){
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String[] input = inputString.split(" ");
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input.length; j++){
//                if(input[i].contains());
            }
        }



        System.out.println(Arrays.toString(input));
    }

    public static void fun2(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String data = str.replace(" ","");
        char[] chars = data.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i < chars.length; i++){
            set.add(chars[i]);
        }
        System.out.println(set.size());
    }

    public static void fun3(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[] input = new int[n];
        ArrayList<Integer> input = new ArrayList<>();
        for(int i = 0; i < n; i++){
            input.add(sc.nextInt());
        }

        System.out.println(function(input)[1]);
    }

    public static int[] function(ArrayList<Integer> input){
        if(input.size() == 2){
            int a = input.get(0);
            int b = input.get(1);
            int[] result = new int[2];
            result[0] = a+b;
            result[1] = a*b;
            return result;
        }
        int[] res = new int[2];
        int maxCore = 0;

        int maxIndex = -1;
        int maxCoreSum = 0;
        for(int i = 0; i < input.size(); i++){
            ArrayList<Integer> tmp =(ArrayList<Integer>)input.clone();
            tmp.remove(i);
            int[] tmpRes = function(tmp);
            int sum = tmpRes[0];
            int core = tmpRes[1];
            if((core + sum*input.get(i)) > maxCore){
                maxCore = core + sum*input.get(i);
                maxIndex = i;
                maxCoreSum = input.get(i)+sum;
            }

        }
        res[0] = maxCoreSum;
        res[1] = maxCore;
        return res;
    }
}
