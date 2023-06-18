package Algorithm;

import java.util.*;

public class P84512 {
    static String[] alp = {"A","E","I","O","U"};
    static HashMap<String, Integer> hm;
    static int answer = 0;
    
    static public void main(String args[]){
        
        // tc 1
        // String word = "AAAAE";

        // tc2
        String word = "EIO";
        
        int result = solution(word);
        System.out.println(result);
    }
    static public int solution(String word) {
        
        hm = new HashMap<>();
        go("", word);
        
        int result = hm.get(word);
        return result;
    }
    
    static public void go(String word, String result){
        if(word.length()==5){
            return;
        }
        for(int i=0;i<5;i++){
            answer++;
            hm.put(word+alp[i], answer);
            go(word+alp[i], result);
        }
    }
}
