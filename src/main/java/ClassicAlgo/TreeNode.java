package main.java.ClassicAlgo;

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
            int count = 0;
            long i = 0;
            Random rd = new Random();
            for(i = 0 ; i < 9899867200L; i++){
                count += i;
//                System.out.println(rd.nextInt(1));
            }
            System.out.println(count);
            System.out.println(i);
        }

}
