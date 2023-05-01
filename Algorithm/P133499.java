package Algorithm;

import java.util.*;

public class P133499 {
    static public void main(String args[]){
        String[] babbling = {"aya", "yee", "u", "maa"};
        int result = solution(babbling);
        System.out.println(result);
    }
    
    static public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i=0;i<babbling.length;i++){
            String word=babbling[i];
            
            if(word.contains("ayaaya") || word.contains("yeye") ||word.contains("woowoo") ||word.contains("mama")){
                continue;
            }
            word = word.replace("aya"," ");
            word = word.replace("ye"," ");
            word = word.replace("woo"," ");
            word = word.replace("ma"," ");
            word = word.replace(" ","");
            if(word.length()==0){
                answer++;
            }
        }
        
        return answer;
    }
}
