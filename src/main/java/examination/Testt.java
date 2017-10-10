package main.java.examination;

import java.util.Scanner;

public class Testt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxValue = 0;
        for(int i = 2; i <= n ; i++){
            int tmpn = n;
            int count = 0;
            while(tmpn>0){
                count+=tmpn%i;
                tmpn-=tmpn%i;
                tmpn/=i;
            }
            maxValue = Math.max(maxValue,count);
        }
        System.out.println(maxValue);
    }

    public static void fun1(int n){
        int maxValue = 0;
        for(int i = 2; i <= n ; i++){
            int tmpn = n;
            int count = 0;
            while(tmpn>0){
                count+=tmpn%i;
                tmpn-=tmpn%i;
                tmpn/=i;
            }
            maxValue = Math.max(maxValue,count);
        }
        System.out.println(maxValue);
    }
}





class Dad{
    String name;
    private String nickname;
    void setName(String name){this.name=name;}
    String getName(){return name;}
    private void setNickName(String n){nickname=n;}
    String getNickname(){return nickname;}

}
class Son extends Dad{
    String outsea;
}
