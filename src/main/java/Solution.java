package main.java;

import java.io.*;
import java.util.*;

/*
 * 20170804
 * ????????????N,?????0,??insertLeft(?????????),insertRight(?????????)???????clear??,?clear?,??????????????????
 */

class Solution {
    public static void main(String[] args) {
//     ArrayList<String> strings = new ArrayList<String>();
//     strings.add("Hello, World!");
//     strings.add("Welcome to CoderPad.");
//     strings.add("This pad is running Java 8.");

//     for (String string : strings) {
//       System.out.println(string);
//     }

        RoundArray ra = new Solution().new RoundArray(10);
        ra.insertLeft(1);
        ra.insertLeft(1);
        ra.insertLeft(1);
        ra.insertRight(2);
        System.out.println(ra.toString());
        ra.clear();
        System.out.println(ra.toString());
        ra.insertLeft(1);
        ra.insertLeft(1);
        ra.insertLeft(1);
        ra.insertRight(2);
        System.out.println(ra.toString());
        ra.clear();
        System.out.println(ra.toString());

    }

    class RoundArray{
        private int n;
        private int initPos;
        private int leftPos;
        private int rightPos;
        private int count;
        private int[] roundArray;
        public RoundArray(int n){
            this.n = n;
            this.initPos = 0;
            this.leftPos = 0;
            this.rightPos = 0;
            this.count = 0;
            roundArray = new int[n];
        }

        public void insertLeft(int value){
            if(count >= n - 1){
                System.out.println("array has been full!");
                return;
            }
            if(leftPos>0){
                leftPos--;
            }else{
                leftPos = n-1;
            }
            roundArray[leftPos] = value;
            count++;
        }

        public void insertRight(int value){
            if(count >= n - 1){
                System.out.println("array has been full!");
                return;
            }
            if(rightPos < n - 1){
                rightPos++;
            }else{
                rightPos = 0;
            }
            roundArray[rightPos] = value;
            count++;
        }

        public void clear(){

            if(leftPos <= initPos && rightPos >= initPos){
                initPos = (leftPos+rightPos)/2;
                leftPos = initPos;
                rightPos = initPos;
                count = 0;
                return;
            }
            if(leftPos > initPos){
                initPos = rightPos - count/2;
                if(initPos < 0){
                    initPos = n+initPos;
                }
            }else{
                //rightPos < initPos
                initPos = leftPos + count/2;
                if(initPos > n-1){
                    initPos = initPos - n;
                }
            }
            leftPos = initPos;
            rightPos = initPos;
            count = 0;
        }

        public String toString(){

            return Arrays.toString(roundArray) + "  initPos:"+initPos + "  leftPos:"+leftPos + "  rightPos:"+rightPos+ "  count:"+count;

        }

    }
}
