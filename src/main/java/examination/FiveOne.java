package main.java.examination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FiveOne extends Thread{
    public static volatile int count = 0;
    public static volatile int finishedThread = 0;
    private char[] input;

    boolean finished = true;
    boolean close = false;
    @Override
    public void run() {
        while(!close){
            while(!finished){
                for(int i = 0; i <= input.length-3; i++){
                    if(input[i]=='u'&&input[i+1]=='5'&&input[i+1]=='1'){
                        count++;
                        i = i+2;
                    }
                }
                finished = true;
            }

        }
        finishedThread++;
    }

    public void setInput(char[] input){
        this.input = input;
        finished = false;
    }
    public void setFineshed(){
        finished = false;
    }
    public void close(){
        close = true;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 2;
        String[] input = new String[n];
        FiveOne thread1 = new FiveOne();
        FiveOne thread2 = new FiveOne();
        FiveOne thread3 = new FiveOne();
        for(int i =0 ; i< n; i++){
            input[i] = sc.nextLine();
            char[] tmp = input[i].toCharArray();
            boolean flag = true;
            while(flag){
                if(thread1.finished){
                    thread1.setInput(tmp);
                    flag = false;
                }else if(thread2.finished){
                    thread2.setInput(tmp);
                    flag = false;
                }else if(thread3.finished){
                    thread3.setInput(tmp);
                    flag = false;
                }
            }
            if(i == n-1){
                thread1.close();
                thread2.close();
                thread3.close();
                System.out.println(thread1.count);
            }

        }
    }
    public static void fun1(){
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String[] vStr = line1.split(" ");
        String[] wStr = line2.split(" ");

        ArrayList<Integer> maxList = new ArrayList<>();
        int maxValue = 0;
        HashMap<Integer,Integer> vMap = new HashMap<>();
        HashMap<Integer,Integer> wMap = new HashMap<>();
        for(int i = 0 ; i < vStr.length; i++) {
            Integer value = Integer.valueOf(vStr[i]);
            Integer weight = Integer.valueOf(wStr[i]);

            if(vMap.containsKey(value)){
                vMap.put(value,vMap.get(value)+1);
            }else{
                vMap.put(value,1);
            }
            int tmpMaxWeight;
            if (wMap.containsKey(value)) {
                tmpMaxWeight = wMap.get(value)+weight;
            }else{
                tmpMaxWeight = weight;
            }
            wMap.put(value,tmpMaxWeight);



            if(maxValue < tmpMaxWeight){
                maxValue = tmpMaxWeight;
                maxList.clear();
                maxList.add(value);

            }else if(maxValue == tmpMaxWeight){
                maxList.add(value);
            }
        }
        int maxId = maxList.get(0);
        int maxIdCount = vMap.get(maxId);
        for(int i = 1; i < maxList.size(); i++){
            if(vMap.get(maxList.get(i)) > maxIdCount) {
                maxIdCount = vMap.get(maxList.get(i));
                maxId = maxList.get(i);
            }
        }
        System.out.println(maxId);
    }
}

