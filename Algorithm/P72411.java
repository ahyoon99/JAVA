package Algorithm;

import java.util.*;
import java.util.Map.Entry;

public class P72411 {
    static public void go(HashMap<String, Integer> combi, int n, String com, int idx, String result){
        if(result.length()>=n){
            if(combi.containsKey(result)==true){
                int count = combi.get(result);
                combi.put(result, count+1);
            }
            else{
                combi.put(result, 1);
            }
            return ;
        }
        if(idx>=com.length()){
            return ;
        }
        String med = String.valueOf(com.charAt(idx));
        go(combi,n,com,idx+1,result+med);
        go(combi,n,com,idx+1,result);
    }
    
    static public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, Integer> combi;
        
        // 각 문자열 오름차순으로 정렬
        for(int i=0;i<orders.length;i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i]=String.valueOf(charArr);
        }
        
        for(int i=0;i<course.length;i++){
            int len = course[i];
            combi = new HashMap<>();
            for(int j=0;j<orders.length;j++){
                go(combi, len, orders[j],0,"");
            }
            
            // 가장 많이 주문된 횟수를 max에 저장
            int max = -1;
            for(Entry<String, Integer> entry : combi.entrySet()){
                max = Math.max(max, entry.getValue());
            }
            
            // 최소 2번 이상 주문된 조합이며, 해당 횟수와 일치하는 조합은 정답 List에 삽입
            for(Entry<String, Integer> entry : combi.entrySet()){
                if(max>=2 && entry.getValue() == max){
                    answer.add(entry.getKey());
                }
            }
        }
        
        // 정답 list를 오름차순으로 정렬
        Collections.sort(answer);
        
        return answer;
    }


    static public void main(String args[]){
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        solution(orders, course);
    }
}
