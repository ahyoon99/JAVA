package Algorithm;

import java.util.*;

public class P138476 {
    static public void main(String args[]){
        int k=6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        
        int result= solution(k, tangerine);
        System.out.println(result);
    }
    
    static public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            int size = tangerine[i];
            if(count.containsKey(size)){
                int cnt = count.get(size);
                count.put(size, cnt+1);
            }
            else{
                count.put(size, 1);
            }
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(count.entrySet());
        Collections.sort(entryList, (o1, o2) -> {
                return o2.getValue()-o1.getValue();
        });
        
        int idx=0;
        while(true){
            if(idx>=entryList.size()){
                break;
            }
            if(k<=0){
                break;
            }
            k-=entryList.get(idx).getValue();
            idx++;
            answer++;
        }
        return answer;
    }
}
