package Algorithm;

import java.util.*;

public class P67256 {
    static public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[][] distance = {{0,4,3,4,3,2,3,2,1,2,1,1},  // 0
                            {3,1,0,1,2,1,2,3,2,3,4,4},  // 2
                            {2,2,1,2,1,0,1,2,1,2,3,3},  // 5
                            {1,3,2,3,2,1,2,1,0,1,2,2}}; // 8
                          // 0,1,2,3,4,5,6,7,8,9,*,#
        
        int left = 10;  // *
        int right = 11; // #

        for(int i=0;i<numbers.length;i++){
            int num = numbers[i];
            if(num==1 || num==4 || num==7){
                left = num;
                answer += "L";
            }
            else if(num==3 || num==6 || num==9){
                right = num;
                answer += "R";
            }
            else{
                int idx=0;
                switch(num){
                    case 0:
                        idx=0;
                        break;
                    case 2:
                        idx=1;
                        break;
                    case 5:
                        idx=2;
                        break;
                    case 8:
                        idx=3;
                        break;
                }
                if(distance[idx][left]<distance[idx][right]){
                    left = num;
                    answer += "L";
                }
                else if(distance[idx][left]>distance[idx][right]){
                    right = num;
                    answer += "R";
                }
                else if(distance[idx][left]==distance[idx][right]){
                    if(hand.equals("right")){
                        right = num;
                        answer += "R";
                    }
                    else{
                        left = num;
                        answer += "L";
                    }
                }
            }
        }
        return answer;
    }

    static public void main(String args[]){
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String result = solution(numbers, hand);
        System.out.println(result);
    }
}
