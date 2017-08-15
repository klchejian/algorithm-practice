package main.java.ClassicAlgo;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by root on 8/12/17.
 */
public class BinaryTree {

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
//        TreeNode t8 = new TreeNode(8);
//        TreeNode t9 = new TreeNode(9);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
//        t4.left=null;
        ArrayList<Integer> list = new ArrayList<>();
//        firstSelect(t1,list);
//        middleSelect(t1,list);
//        lastSelect(t1,list);
        iterativePostOrder(t1,list);
        System.out.println(list);

    }

    public static void firstSelect(TreeNode head, ArrayList<Integer> list){
        if(head == null)
            return;
        list.add(head.value);
        firstSelect(head.left,list);
        firstSelect(head.right,list);
    }

    public static void middleSelect(TreeNode head,ArrayList<Integer> list){
        if(head == null){
            return;
        }
        middleSelect(head.left,list);
        list.add(head.value);
        middleSelect(head.right,list);
    }

    public static void lastSelect(TreeNode head,ArrayList<Integer> list){
        if(head == null){
            return;
        }
        lastSelect(head.left,list);
        lastSelect(head.right,list);
        list.add(head.value);
    }

    public static void iterativePreOrder(TreeNode head, ArrayList<Integer> list){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(head != null){
            stack.push(head);
            while(!stack.empty()){
                head = stack.pop();
                list.add(head.value);
                if(head.right != null)
                    stack.push(head.right);
                if(head.left != null)
                    stack.push(head.left);
            }
        }
    }

    public static void iterativeInOrder(TreeNode head, ArrayList<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        while(head != null){
            while(head != null) {
                if (head.right != null)
                    stack.push(head.right);
                stack.push(head);
                head = head.left;
            }
                head = stack.pop();
                if(!stack.isEmpty() && head.right==null){
                    list.add(head.value);
                    head = stack.pop();
                }

                list.add(head.value);
                if(!stack.isEmpty())
                    head = stack.pop();
                else
                    head = null;
        }
    }

    public static void iterativePostOrder(TreeNode p, ArrayList<Integer> list){
        TreeNode q = p;
        Stack<TreeNode> stack = new Stack<>();
        while(p != null){
            //put the left node into stack
            while(p.left != null){
                stack.push(p);
                p = p.left;
            }

            // if there is no right or right has been add to list
            while(p != null && (p.right == null || p.right == q)){
                list.add(p.value);
                q = p;
                if(stack.isEmpty()) return;
                p = stack.pop();
            }

            stack.push(p);
            p = p.right;
        }
    }

}
