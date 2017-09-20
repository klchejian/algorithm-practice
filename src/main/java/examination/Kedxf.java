package main.java.examination;


import java.util.*;
import java.util.Scanner;

public class Kedxf {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       String[] teams = new String[n];
        HashMap<String,Integer> score1 = new HashMap<>();
        HashMap<String,Integer> score2 = new HashMap<>();
        HashMap<String,Integer> score3 = new HashMap<>();
       for(int i = 0; i < n; i++){
           teams[i] = sc.nextLine();
           score1.put(teams[i],0);
           score2.put(teams[i],0);
           score3.put(teams[i],0);
       }

       for(int i = 0; i < n*(n-1)/2; i++){
           String tmp = sc.nextLine();
           String team1 = tmp.split(" ")[0].split("-")[0];
           String team2 = tmp.split(" ")[0].split("-")[1];
           String scor1 = tmp.split(" ")[1].split("-")[0];
           String scor2 = tmp.split(" ")[1].split("-")[1];
           if(Integer.valueOf(scor1)>Integer.valueOf(scor2)){
               score1.put(team1,score1.get(team1)+3);
               score2.put(team1,score2.get(team1)+ (Integer.valueOf(scor1)-Integer.valueOf(scor2)) );
           }else if(Integer.valueOf(scor1)<Integer.valueOf(scor2)){
               score1.put(team2,score1.get(team2)+3);
               score2.put(team2,score2.get(team2)+ (Integer.valueOf(scor2)-Integer.valueOf(scor1)) );
           }else if(Integer.valueOf(scor1)==Integer.valueOf(scor2)){
               score1.put(team1,score1.get(team1)+1);
               score1.put(team2,score1.get(team2)+1);
           }
           score3.put(team1,score3.get(team1)+Integer.valueOf(scor1));
           score3.put(team2,score3.get(team2)+Integer.valueOf(scor2));
       }
        for (int i = 0; i < n; i++){
            int k = i;
            for(int j = i; j < n; j++){
                if(score1.get(teams[j])<score1.get(teams[k]) || ( score1.get(teams[j])==score1.get(teams[k]) &&  score2.get(teams[j])<score2.get(teams[k]) )   || ( score1.get(teams[j])==score1.get(teams[k]) && score2.get(teams[j])==score2.get(teams[k]) &&  score3.get(teams[j])<score3.get(teams[k]) )){
                    k = j;
                }
            }
            String tmp = teams[k];
            teams[k] = teams[i];
            teams[i] = tmp;
        }
        for(int i = 0; i < n/2; i++){
            System.out.print(teams[n-i-1]);
        }

    }



    public static void fun2(){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] input = new int[n][2];
        HashMap<Integer,ArrayList<Integer>> res = new HashMap<Integer,ArrayList<Integer>>();
        ArrayList<Integer> tmpArr = new ArrayList<Integer>();
        int count = 0;
        for(int i = 0; i < n ; i++){
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
            if(res.containsKey(input[i][0])){
                tmpArr = res.get(input[i][0]);
                tmpArr.add(input[i][1]);
                res.put(input[i][0],tmpArr);
                count++;
            }else{
                tmpArr = new ArrayList<Integer>();
                tmpArr.add(input[i][1]);
                res.put(input[i][0],tmpArr);
            }
        }

        if(count>0) {
            for (Integer key : res.keySet()) {
                tmpArr = res.get(key);
                if (tmpArr.size()>1) {
                    StringBuilder sb = new StringBuilder("");
                    for(int i = 0; i < tmpArr.size(); i++){
                        sb.append(" "+tmpArr.get(i));
                    }
                    if(key<10){
                        System.out.println("0" + key + sb.toString());
                    }else {
                        System.out.println(key + sb.toString());
                    }
                }
            }
        }else{
            System.out.println("YES");
        }
    }


    public static void fun1(){
        //        Scanner sc  = new Scanner(System.in);
//        String input = sc.nextLine();
        String input = "LRRLRL";
        char[] inputArr = input.toCharArray();
        ArrayList<Character> inputList = new ArrayList<>();
        for(int i = 0; i < inputArr.length; i++){
            inputList.add(inputArr[i]);
        }
        System.out.println(getMinConflict(inputList));
    }

    public static int getMinConflict( ArrayList<Character> input){




        int minRes = input.size();
            for(int i = 0; i < input.size(); i++){
                if(input.get(i)=='R' && i<(input.size()-1) && input.get(i+1)=='L'){
                    ArrayList<Character> tmp1 = (ArrayList<Character>)input.clone();
                    ArrayList<Character> tmp2 = (ArrayList<Character>)input.clone();

                    tmp1.remove(i);
                    tmp2.remove(i+1);
                    minRes = Math.min(getMinConflict(tmp1),getMinConflict(tmp2));
                }
            }


        return minRes;
    }
}
