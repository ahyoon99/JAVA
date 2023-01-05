package Algorithm;

import java.util.*;

public class P118667 {
    static public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        int[] queue = new int[queue1.length+queue2.length];
        System.arraycopy(queue1, 0, queue, 0, queue1.length);
        System.arraycopy(queue2, 0, queue, queue1.length, queue2.length);
        
        int idx1 = 0;
        int idx2 = queue1.length;
        
        long queue1Sum = 0;
        for(int i=0;i<queue1.length;i++){
            queue1Sum+=queue1[i];
        }
        
        long sum = 0;
        for(int i=0;i<queue.length;i++){
            sum+=queue[i];
        }
        
        // 합이 홀수 인 경우 -> return -1
        if(sum%2!=0){
            return -1;
        }
        
        while(idx1<=idx2){
            if(queue1Sum==sum/2){
                return answer;
            }
            if(queue1Sum>sum/2){
                queue1Sum-=queue[idx1];
                answer++;
                if(idx1==queue.length-1){
                    idx1=0;
                }
                else{
                    idx1++;
                }
            }
            else if(queue1Sum<sum/2){
                queue1Sum+=queue[idx2];
                answer++;
                if(idx2==queue.length-1){
                    idx2=0;
                }
                else{
                    idx2++;
                }
            }
        }
        return -1;
    }
    
    static public void main(String args[]){
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        solution(queue1, queue2);
    }
}
