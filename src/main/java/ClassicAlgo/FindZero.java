package main.java.ClassicAlgo;

public class FindZero {
    public static void main(String[] args){
        for(int i = 0; i < 100; i++){
            System.out.println("i="+i+" result is :"+testn(i));
        }
    }

    public static long testn(int n){
        long res = 1;
        for(int i = 1; i <= n; i++){
            res*=i;
        }
        return res;
    }


}
