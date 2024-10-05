package Algorithm;

import java.util.*;

public class P142085 {
    static public void main(String args[]){
        int n = 7;
        int k = 3;
        int[] enemy = {4,2,4,5,3,3,1};

        int result = solution(n, k, enemy);
        System.out.println(result);
    }
    
    static public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        if(k>=enemy.length){
            return enemy.length;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<enemy.length;i++){
            n-=enemy[i];
            pq.add(enemy[i]);
            
            if(n<0){
                if(k>0){
                    n+=pq.poll();
                    k--;
                }
                else{
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}
