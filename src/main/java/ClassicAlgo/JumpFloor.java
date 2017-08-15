package main.java.ClassicAlgo;

/**
 * Created by root on 8/5/17.
 */
public class JumpFloor {

    public static void main(String[] args){
        Iuser ss;


        for(int i = 4 ; i < 10; i++){
            System.out.println(i+":"+jumpRecursive(i) + "----" + jumpUnrecursive(i));
        }
    }

    public static Iuser test(){
        return null;
    }

    public static int jumpRecursive(int n) {
        if(n<0){
            return 0;
        }

        int[] stripe = {0,1,2};
        if(n<3){
            return stripe[n];
        }
        return jumpRecursive(n-1) + jumpRecursive(n-2);
    }

    public static int jumpUnrecursive(int n) {
        if(n < 0){
            return 0;
        }

        int[] stripe = {0,1,2};

        if(n<3){
            return stripe[n];
        }

        int nReturn = 0;
        int fibFirst = 1;
        int fibTwo = 2;

        for(int i = 3; i <= n; i++){
            nReturn = fibFirst+fibTwo;
            fibFirst = fibTwo;
            fibTwo = nReturn;
        }

        return nReturn;
    }

}
