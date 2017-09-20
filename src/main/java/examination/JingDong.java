package main.java.examination;

import java.util.Stack;

public class JingDong {
    public static void main(String[] args){
//        Other o = new Other();
//        new JingDong().addOne(o);
//        System.out.println(o.i);
        fun1("(((())))(())");

    }
    public void addOne(final Other o){
        o.i++;
    }

    class Other{
        public int i;
    }


    public static void fun1(String input){
//        String input = "(((())))";
        int res = 1;
        int leftNum = 0;
        char[] inputs = input.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < inputs.length; i++){
            if(inputs[i]=='(') {
                stack.push(inputs[i]);
            }else if(inputs[i] == ')') {
                if(stack.size() == 1){
                    int count = 0;
                    for(int j = i - 1; j>=0 &&  inputs[j]==')'; j--){
                        count++;
                    }
                    for(int j = i; j < inputs.length && inputs[j]==')'; j++){
                        count++;
                    }
                    res *= count;
                    inputs[i] = 'x';
                    inputs[leftNum] = 'x';
                    i = leftNum;
                    leftNum++;

                }
                stack.pop();
            }
        }
        System.out.println(res);
    }
}
