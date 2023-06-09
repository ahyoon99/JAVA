package Algorithm;

import java.util.*;

public class P42587 {
    static public void main(String args[]){
        int[] priorities = {2,1,3,2};
        int location = 2;

        int result = solution(priorities, location);
        System.out.println(result);
    }
    
    static public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<priorities.length;i++){
            q.add(priorities[i]);
        }
        
        // 내림차순 정렬
        Integer[] integerPriorities = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(integerPriorities, Comparator.reverseOrder());
        
        int idx=0;
        while(!q.isEmpty()){
            int top = q.poll();
            if(top==integerPriorities[idx]){
                idx++;
                answer++;
                if(location==0){
                    break;
                }
            }
            else{
                q.add(top);
            }
            if(location==0){
                location=q.size()-1;
            }
            else{
                location--;
            }
        }
        return answer;
    }
}
