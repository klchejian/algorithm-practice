package main.java.examination;

import java.util.Scanner;

/**
 * Created by root on 8/13/17.
 */
public class Alibb {
    static int maxScore(int[] score) {
        int totalScore = 0;
        if(score.length < 1){
            return score[0];
        }
        for(int i =0; i < score.length; i++){
            if(score[i] == 0){
                continue;
            }else{
                if(i == 0){
                    totalScore += score[i] * score[i + 1];
                }else if(i == score.length - 1){
                    totalScore += score[i] * score[i-1];
                }else {
                    if(score[i-1]==score[i+1] && score[i+1] == 0){
                        totalScore = score[i];
                    }else{
                        int left = score[i-1]==0?1:score[i-1];
                        int rigot = score[i+1]==0?1:score[i+1];
                        totalScore += left * score[i] * rigot;
                    }

                }
            }

        }
        return totalScore;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _score_size = 0;
        _score_size = Integer.parseInt(in.nextLine().trim());
        int[] _score = new int[_score_size];
        int _score_item;
        for(int _score_i = 0; _score_i < _score_size; _score_i++) {
            _score_item = Integer.parseInt(in.nextLine().trim());
            _score[_score_i] = _score_item;
        }

        res = maxScore(_score);
        System.out.println(String.valueOf(res));

    }
}
