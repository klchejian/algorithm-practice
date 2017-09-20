package main.java.examination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Long> list = new ArrayList<Long>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLong());
        }
        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                num += getNum(list.get(i), list.get(j));
            }
        }
        System.out.println(num);
    }
    static int getNum(long a, long b) {
        long result = a^b;
        int num = 0;
        while (result != 0) {
            result &= (result - 1);
            num++;
        }
        return num;
    }

    public static void fun2(){
        // input 1 ddiaiji
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] inputs = new String[n];
        for(int i = 0; i < n ; i++){
            inputs[i] = sc.nextLine();
        }

        int[] res = new int[n];


        for(int i = 0; i < inputs.length; i++){
            char[] str = inputs[i].toCharArray();
            for(int j = 0; j < str.length; j++){
                if(str[j] == 'd'){
                    for(int k = j+i; k < str.length; k++){
                        if(str[k] == 'j'){
                            for(int m = k+1; m < str.length; m++){
                                if(str[m] == 'i'){
                                    res[i]+=1;
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < inputs.length; i++){
            System.out.println(res[i]);
        }
    }
}
