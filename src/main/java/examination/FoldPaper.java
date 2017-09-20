package main.java.examination;

import java.util.*;
public class FoldPaper {

    public static void main(String[] args){
        String[] res = foldPaper(2);
        System.out.println(Arrays.toString(res));
    }
    public static String[] foldPaper(int n) {
        // write code here
        if(n <= 0)
            return null;
        int count=(1<<n)-1;//需要打印的次数为2^n-1。
        String[] strs=new String[count];
        int[] index={0};
        print(1,n,true,strs,index);//由根节点开始遍历过程
        return strs;
    }
    public static void print(int level,int n,boolean flag,String[] strs,int[] index)
    {
        if(level > n)//level超出n的时候返回。
            return;
        print(level+1,n,true,strs,index);//先递归左结点，并打印down
        strs[index[0]++]=(flag == true)?"down":"up";//打印本结点的值，并将index++
        print(level+1,n,false,strs,index);//再递归打印右结点的值up;
    }
}