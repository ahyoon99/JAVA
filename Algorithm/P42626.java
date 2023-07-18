package Algorithm;

import java.util.*;

public class P42626 {
    static public void main(String args[]){
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int result = solution(scoville, K);
        System.out.println(result);
    }

    static public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            minHeap.add(scoville[i]);
        }
        
        while(minHeap.peek()<K){
            if(minHeap.size()==1){
                return -1;
            }
            int min = minHeap.poll();
            int minNext = minHeap.poll();
            minHeap.add(min+minNext*2);
            answer++;
        }
        
        return answer;
    }
    
}
