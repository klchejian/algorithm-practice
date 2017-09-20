package main.java.examination;

public class Solution {

    public static void main(String[] args)
    {
//        System.out.println(minCstToApples(19,3,10,4,15));
        long []x[] = new long[1][1];
//        short xx[1][1] = new short[][];
        int xxxx[][] = new int[1][1];
//        byte xxxxx[][] = new byte[][];



    }

    public static int minCstToApples(int totalApples, int lotSize1, int lotPrice1, int lotSize2, int lotPrice2){
        double price1 = (double)lotPrice1/(double)lotSize1;
        double price2 = (double)lotPrice2/(double)lotSize2;
        if(price1 == price2){
            return lotPrice1*totalApples/lotSize1;
        }
        int i = 0;
        int num1 = 0;
        int num2 =0;
        int temp = 0;
        if(price1<price2){
            i = -1;
            do{
                i++;

                num2 = i;
                temp = totalApples - num2*lotSize2;
            }while(temp%lotSize1 > 0);
            num1 = temp/lotSize1;
        }else{
            i = -1;
            do{
                i++;

                num1 = i;
                temp = totalApples - num1*lotSize1;
            }while(temp%lotSize2 > 0);
            num2 = temp/lotSize2;
        }
        return num1*lotPrice1 + num2*lotPrice2;
    }

}
