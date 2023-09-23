package Algorithm;

import java.util.*;

public class P152996 {
    static public void main(String args[]){
        int[] weights = {100,180,360,100,270};
        long result = solution(weights);

        System.out.println(result);
    }
    
    static public long solution(int[] weights) {
        long answer = 0;
        
        HashMap<Double, Integer> hm = new HashMap<>();
        
        Arrays.sort(weights);
        for(int i : weights){
            double a = i*1.0;
            double b = (i*2.0)/3.0;
            double c = (i*1.0)/2.0;
            double d = (i*3.0)/4.0;
            
            if(hm.containsKey(a)){
                answer+=hm.get(a);
            }
            if(hm.containsKey(b)){
                answer+=hm.get(b);
            }
            if(hm.containsKey(c)){
                answer+=hm.get(c);
            }
            if(hm.containsKey(d)){
                answer+=hm.get(d);
            }
            hm.put((i*1.0), hm.getOrDefault((i*1.0), 0)+1);
        }
        return answer;
    }
}
