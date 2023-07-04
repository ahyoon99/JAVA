package Algorithm;

import java.util.*;

public class P178870 {

    static int resultStartIdx=-1;
    static int resultEndIdx=-1;
    static int resultMin=1000001;
    
    static public void main(String args[]){
        // tc1
        int[] sequence = {1,2,3,4,5};
        int k = 7;

        // tc2
        // int[] sequence = {1,1,1,2,3,4,5};
        // int k = 5;

        // tc3
        // int[] sequence = {2,2,2,2,2};
        // int k = 6;

        int[] result = solution(sequence, k);
        System.out.println(result[0]+","+result[1]);
    }
    
    static public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int startIdx=0;
        int endIdx=1;
        int sum=sequence[0];
        while(true){
            if(startIdx>=sequence.length && endIdx>=sequence.length){
                break;
            }
            if(sum==k){
                if(resultMin>endIdx-1-startIdx){
                    resultStartIdx=startIdx;
                    resultEndIdx=endIdx-1;
                    resultMin=endIdx-startIdx-1;
                }
            }
            if(sum<=k){
                if(endIdx>=sequence.length){
                    break;
                }
                sum+=sequence[endIdx];
                endIdx++;
            }
            else if(sum>k){
                if(startIdx>=sequence.length){
                    break;
                }
                sum-=sequence[startIdx];
                startIdx++;
            }
        }
        answer[0]=resultStartIdx;
        answer[1]=resultEndIdx;
        return answer;
    }
}
