package Algorithm;

import java.util.*;

public class P12927 {
    static public void main(String args[]){
        int n = 4;
        int[] works = {4,3,3};

        long result = solution(n, works);
        System.out.println(result);
    }

    static public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            pq.offer(work);
        }
        
        for(int i=0;i<n;i++){
            int num = pq.poll();
            if(num==0){
                break;
            }
            pq.offer(num-1);
        }
        
        while (!pq.isEmpty()) {
            int num = pq.poll();
            answer += Math.pow(num,2);
        }
        return answer;
    }
}
