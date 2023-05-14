package Algorithm;

import java.util.*;

public class P42578 {
    static public void main(String args[]){
        String[][] clothes = { {"yellow_hat", "headgear"},
                                {"blue_sunglasses", "eyewear"},
                                {"green_turban", "headgear"}};
        int result = solution(clothes);
        System.out.println(result);
    }

    static public int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap<String, Integer> closet = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            String category = clothes[i][1];
            if(closet.containsKey(category)){
                int cnt = closet.get(category);
                closet.put(category, cnt+1);
            }
            else{
                closet.put(category, 1);
            }
        }
        
        Iterator<Integer> it = closet.values().iterator();
        answer = 1;
        
        // 입지 않는 경우를 추가하여 모든 조합 계산하기
        while(it.hasNext()){
            answer*=(it.next().intValue()+1);
        }
        
        // 아무종류의 옷도 입지 않는 경우 제외하기
        answer-=1;
        
        return answer;
    }
}
