package main.java.ClassicAlgo;

import java.util.Arrays;

public class LongestPalindrome {

   public static int min(int x, int y){
       return x<y?x:y;
   }
    public static int max(int x,int y){
       return ((x)<(y)?(y):(x));
   }
    public static String findLongestPalindrome3(String input)
    {

        int length=input.length();
        StringBuilder s = new StringBuilder("");
        s.append(input.toCharArray()[0]);
        for(int i=1;i<length;i++)//给字符串添加 #
        {
            s.append("#");
            s.append(input.toCharArray()[i]);
        }
        length=length*2-1;//添加#后字符串长度
        length = s.length();
        int[] rad=new int[length];
        char[] ss = s.toString().toCharArray();
        rad[0]=0;

        for(int i=1,j=1,k;i<length;i=i+k)
        {
            while(i-j>=0&&i+j<length&&ss[i-j]==ss[i+j])
                j++;
            rad[i]=j-1;
            for(k=1;k<=rad[i]&&rad[i-k]!=rad[i]-k;k++)//镜像,遇到rad[i-k]=rad[i]-k停止，这时不用从j=1开始比较
                rad[i+k]=min(rad[i-k],rad[i]-k);

            j=max(j-k,0);//更新j

        }
        int max=0;
        int center = 0;
        for(int i=0;i<length;i++)
        {
            if(rad[i]>max)
            {
                max=rad[i];
                center=i;
            }
        }
        int startIndex = center-max;
        int endIndex = center-max + 2*max +1;
        return Arrays.toString(s.toString().substring(startIndex,endIndex).split("#"));

    }

    public static void main(String[] args) {
        String input = "abcdefghijkldcbaabcdmnopqrstuvwxyz";
        System.out.println(findLongestPalindrome3(input));
    }

}
