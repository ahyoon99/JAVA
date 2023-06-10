package Algorithm;

import java.util.*;

public class P42840 {
    static public void main(String args[]){
        int[] answers = {1,3,2,4,2};

        ArrayList<Integer> result = solution(answers);
        System.out.println(result);
    }

    static public ArrayList<Integer> solution(int[] answers) {
        
        int[] person1 = {1,2,3,4,5}; // 5개
        int[] person2 = {2,1,2,3,2,4,2,5}; // 8개
        int[] person3 = {3,3,1,1,2,2,4,4,5,5}; //10개
        
        int[] score = new int[3];
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==person1[i%5]){
                score[0]++;
            }
            if(answers[i]==person2[i%8]){
                score[1]++;
            }
            if(answers[i]==person3[i%10]){
                score[2]++;
            }
        }
        int max=-1;
        for(int i=0;i<score.length;i++){
            if(score[i]>max){
                max=score[i];
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<score.length;i++){
            if(score[i]==max){
                answer.add(i+1);
            }
        }
        return answer;
    }
}
