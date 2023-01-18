package Algorithm;

import java.util.*;

public class P77484 {
    static public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int score = 0;
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int zeroCnt = 0;
        for(int n : lottos){
            if(n==0){
                zeroCnt++;
            }
            else{
                break;
            }
        }
        
        for(int i=zeroCnt;i<lottos.length;i++){
            int num = lottos[i];
            for(int j=0;j<win_nums.length;j++){
                if(num==win_nums[j]){
                    score++;
                }
            }
        }
        
        answer[0]=rank(score+zeroCnt);
        answer[1]=rank(score);
        return answer;
    }
    static public int rank(int score){
        switch(score){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }

    static public void main(String args[]){
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        solution(lottos, win_nums);
    }
}
