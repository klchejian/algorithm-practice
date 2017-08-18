package main.java.ClassicAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by root on 8/12/17.
 */
public class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
        public TreeNode(TreeNode left, TreeNode right, int v){
            this.left = left;
            this.right = right;
            this.value = v;
        }

        public TreeNode(int v){
            left=null;
            right=null;
            value=v;
        }

        public static void main(String[] args){
//            int[] a = {1,2,3,4,5,6};
//            System.out.println(Arrays.toString(a));
//            int[] a = new int[4];
//            ArrayList<Integer> al = new ArrayList<>();
//            al.add(1);
//            al.add(1);
//            al.add(1);
//            al.add(1);
//            System.out.println();

//            int a = 1;
//            for(int i = 0 ; i < 10 ; i++){
//                a = -128;
//                a = a >>> i;
//                System.out.println(a);
//
//                a = -128;
//                a = a >> i;
//                System.out.println(a);
//            }

            TreeNode test = new TreeNode(33);
            System.out.println("before"+test.value);
            inputtest(test);
            System.out.println("after"+test.value);


        }

        public static void inputtest(TreeNode input){
            System.out.println(input.value);
            input.value = 501;
            System.out.println(input.value);
            input = new TreeNode(400);
            System.out.println(input.value);

        }

}
