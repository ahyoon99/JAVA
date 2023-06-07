package Algorithm;

import java.util.*;

public class P42586 {
    static public void main(String args[]){
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};

        ArrayList<Integer> result = solution(progresses, speeds);
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
        System.out.println();
    }
    
    static public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            if((100-progresses[i])%speeds[i]==0){
                q.add((100-progresses[i])/speeds[i]);
            }
            else{
                q.add((100-progresses[i])/speeds[i] + 1);
            }
        }
        
        int top =0;
        int cnt=0;
        while(!q.isEmpty()){
            top = q.poll();
            while(!q.isEmpty() && top>=q.peek()){
                cnt++;
                q.poll();
            }
            answer.add(cnt+1);
            cnt=0;
        }
        
        return answer;
    }
}
