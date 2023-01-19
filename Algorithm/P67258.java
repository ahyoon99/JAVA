package Algorithm;

import java.util.*;
import java.util.Map.*;

public class P67258 {
    static public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        HashSet<String> kinds = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> hm = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        
        if(kinds.size()==1) return new int[]{1,1};
        
        int start = 0;
        int tmp_start = 0;
        int min_distance = Integer.MAX_VALUE;
        
        for(String gem : gems){
            q.add(gem);
            hm.put(gem, hm.getOrDefault(gem,0)+1);
            
            while(true){
                String tmp = q.peek();
                if(hm.get(tmp)>1){
                    hm.put(tmp, hm.get(tmp)-1);
                    q.poll();
                    tmp_start++;
                }
                else {
                    break;
                }
            }
            
            if(hm.size()==kinds.size() && min_distance>q.size()){
                min_distance = q.size();
                start = tmp_start;
            }
        }
        return new int[]{start+1, start+min_distance};
    }

    static public void main(String args[]){
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        solution(gems);
    }
}
