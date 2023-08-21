package Algorithm;

import java.util.*;

public class P120812 {
    static public void main(String args[]){
        int[] array = {1,2,3,3,3,4};

        int result = solution(array);
        System.out.println(result);
    }

    static public int solution(int[] array) {
        int answer = -1;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<array.length;i++){
            hm.put(array[i], hm.getOrDefault(array[i], 0)+1);
        }
        
        ArrayList<Integer> values = new ArrayList<>(hm.values());
        Collections.sort(values, Collections.reverseOrder());
        int max = values.get(0);
        
        for(int entry : hm.keySet()){
            if(hm.get(entry)==max){
                if(answer==-1){
                    answer = entry;
                }        
                else{
                    answer=-1;
                    break;
                }
            }
        }
        return answer;
    }
}
