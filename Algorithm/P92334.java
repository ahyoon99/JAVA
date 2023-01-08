package Algorithm;

import java.util.*;

public class P92334 {
    static public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Integer> id = new LinkedHashMap(); 
        Map<String,List<String>> score = new LinkedHashMap();
        
        for(int i=0;i<id_list.length;i++){
            String nickname = id_list[i];
            id.put(nickname,0);
            List<String> people = new ArrayList<>();
            score.put(nickname, people);
        }
        report = Arrays.stream(report).distinct().toArray(String[]::new);
        
        for(int i=0;i<report.length;i++){
            String[] splitResult = report[i].split(" ");
            String member1 = splitResult[0];
            String member2 = splitResult[1];
            
            // 신고 당한 횟수 update
            int num = id.get(member2);
            id.put(member2,num+1);
            
            // 유저가 신고한 ID update
            List<String> getPeople = score.get(member1);
            getPeople.add(member2);
            score.put(member1,getPeople);
        }
        
        int idx=0;
        for(String key : score.keySet()){
            int result=0;
            List<String> personList = score.get(key);
            for(int i=0;i<personList.size();i++){
                String p = personList.get(i);
                if(id.get(p)>=k){
                    result++;
                }
            }
            answer[idx] = result;
            idx++;
        }
        return answer;
    }

    static public void main(String args[]){
        String[] id_list={"muzi", "frodo", "apeach", "neo"};
        String[] report={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        solution(id_list, report, k);
    }
}
