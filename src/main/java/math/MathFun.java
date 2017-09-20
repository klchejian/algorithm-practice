package main.java.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by root on 8/5/17.
 */
public class MathFun {

    public static void main(String[] args) {
        Random r = new Random();
        int a = r.nextInt(10);
        int b= r.nextInt(10);
        System.out.println("a="+a);
        System.out.println("b="+b);
        int res = a-b;
        System.out.println("myr="+sub(a,b));
//       n(Integer.MAX_VALUE);
    }

    public static int add(int a,int b) {
        int sum,carry ;
        System.out.println("a:"+Integer.toBinaryString(a));
        System.out.println("b:"+Integer.toBinaryString(b));
        do {
            sum = a^b;
            carry = (a&b)<<1;
            System.out.println("s u m:"+Integer.toBinaryString(sum));
            System.out.println("carry:"+Integer.toBinaryString(carry));
            a = sum;
            b = carry;
        }while(carry != 0);

        return sum;
    }

    public static int sub(int a, int b) {
        return add(a,add(~b,1));
    }

    public static int muti(int a , int b) {
        boolean flag=(b<0);
        if(flag) b=-b;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<32;i++)
        {
            map.put(1<<i, i);
        }
        int sum=0;
        while(b>0)
        {
            int last=b&(~b+1); //get the lastest 1
            int count=map.get(last);//get the position of the one
            sum+=a<<count;
            b=b&(b-1);
        }
        if(flag) sum=-sum;
        return sum;
    }

    public static double div(int a, int b){
        boolean flag=(a<0)^(b<0);
        if(a<0) a=-a;
        if(b<0) b=-b;
        if(a<b) return 0;
        int msb=0;
        while((b<<msb)<a)
        {
            msb++;
        }
        int q=0;
        for(int i=msb;i>=0;i--)
        {
            if((b<<i)>a) continue;
            q|=(1<<i);
            a-=(b<<i);
        }
        if(flag) return -q;
        return q;
    }
}
