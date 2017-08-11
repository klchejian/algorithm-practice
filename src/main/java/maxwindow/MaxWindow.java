package main.java.maxwindow;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

/**
 * Created by root on 7/19/17.
 */
public class MaxWindow {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] arr = new int[10];
        int b = arr.length;
        Random rd = new Random();


        for(int i = 0; i<arr.length; i++) {
            arr[i] = rd.nextInt(100);
            while (arr[i] < 10) {
                arr[i] = rd.nextInt(100);
            }
//            System.out.print(arr[i] + "  ");

        }
        arr = new int[3];
        arr[0] = 2;
        arr[1] = 4;
        arr[2] = 7;

//        int res[] = getMaxWindow(arr,4);

        int res[] = maxSlidingWindow(arr,2);
        for(int i = 0; i<res.length ;i++){
            System.out.print(res[i] + "  ");
        }
    }

    public static int[] getMaxWindow(int[] arr, int w) {
        if(arr == null || w < 1 || arr.length < w ) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0 ; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.getLast()] <= arr[i] ) {
                qmax.removeLast();
            }
            qmax.addLast(i);
            if(qmax.getFirst() == (i-w) ) {
                qmax.removeFirst();
            }
            if (i >= (w-1) ) {
                res[index++] = arr[qmax.getFirst()];
            }
        }
        return res;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if( k < 1 || k > nums.length ){
            return new int[0];
        }

        int size = nums.length;
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        int pos = 0;
        boolean flag = true;

        for(int i = 0; i < nums.length; i++){
            flag = true;
            while(flag) {
                if(qmax.isEmpty()){
                    flag = false;
                } else if(nums[i] > nums[qmax.getLast()]) {
                    qmax.removeLast();
                } else {
                    flag = false;
                }
            }
            qmax.add(i);
            if( (i - pos ) == (k-1) ){
                if(pos == qmax.getFirst()){
                    res[pos] = nums[qmax.removeFirst()];
                }else {
                    res[pos] = nums[qmax.getFirst()];
                }
                pos++;
            }


        }

        for(int i = pos ; i < res.length; i++){
            res[i] = nums[qmax.removeFirst()];
        }

        return res;
    }

}
