package Algorithm;

import java.util.*;

public class P42890 {
    static int answer;
    static int n;
    static int m;
    static int[] order;
    static HashSet<String> candidateKey;

    static public void main(String args[]) {
        String[][] relation = {{"100","ryan","music","2"},
                            {"200","apeach","math","2"},
                            {"300","tube","computer","3"},
                            {"400","con","computer","4"},
                            {"500","muzi","music","3"},
                            {"600","apeach","music","2"}};
        int result = solution(relation);
        System.out.println(result);
    }
    
    static public int solution(String[][] relation) {
        n = relation[0].length;
        m = relation.length;
        candidateKey = new HashSet<String>();
        
        for(int i=1;i<=n;i++){
            order = new int[i];
            go(0,0, relation);
        }
        
        answer = candidateKey.size();
        return answer;
    }
    
    static void go(int orderIdx, int idx, String[][] relation){
        if(orderIdx>=order.length){
            check(relation);
            return;
        }
        if(idx>=n){
            return;
        }
        
        order[orderIdx]=idx;
        go(orderIdx+1, idx+1, relation);
        order[orderIdx]=0;
        go(orderIdx, idx+1, relation);        
    }
    
    static void check(String[][] relation){
        HashSet<String> list = new HashSet<>();
        
        boolean isValid = true;
        for(int i=0;i<m;i++){
            String key = "";
            for(int j=0;j<order.length;j++){
                key+=relation[i][order[j]];
            }
            if(!list.contains(key)){
                list.add(key);
            }
            else{
                return;
            }
        }
        
        if(isValid){
            String key = "";
            for(int i=0;i<order.length;i++){
                key+=order[i];
            }
            
            for(String value : candidateKey){
                int count = 0;
                for(int i=0;i<key.length();i++){
                    String temp = String.valueOf(key.charAt(i));
                    if(value.contains(temp)){
                        count++;
                    }
                }
            
                if(count==value.length()){
                    isValid = false;
                    break;
                }
            }
            
            if(isValid){
                candidateKey.add(key);
            }
        }
    }
}
