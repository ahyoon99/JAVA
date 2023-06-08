package Algorithm;

import java.util.*;

public class P131127 {
    static public void main(String args[]){
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3,2,2,2,1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int result = solution(want, number, discount);
        System.out.println(result);
    }

    static public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> hm = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        
        for(int i=0;i<10;i++){
            q.add(discount[i]);
            hm.put(discount[i], hm.getOrDefault(discount[i],0)+1);
        }
        
        int idx=10;
        while(idx<=discount.length){
            
            boolean check=true;
            for(int i=0;i<want.length;i++){
                String wantProduct = want[i];
                int wantCnt = number[i];
                
                if(hm.getOrDefault(wantProduct, 0) < wantCnt){
                    check=false;
                    break;
                }
            }
            if(check){
                answer++;
            }
            
            if(idx==discount.length){
                break;
            }
            
            String productRemoved = q.poll();
            int cnt = hm.get(productRemoved);
            hm.put(productRemoved, cnt-1);
            
            q.add(discount[idx]);
            hm.put(discount[idx], hm.getOrDefault(discount[idx], 0)+1);
            
            idx++;
        }
        return answer;
    }
}
