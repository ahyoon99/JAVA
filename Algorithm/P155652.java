package Algorithm;

import java.util.*;

public class P155652 {
    static public void main(String args[]){
        String s = "aukks";
        String skip = "wbqd";
        int index=5;

        String result = solution(s, skip, index);
        System.out.println(result);
    }

    static public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0;i<s.length();i++){
            char com = s.charAt(i);
            int count=1;
            int idx = index;
            while(count<=idx){
                com = (char)(com+1);
                if(com >'z'){
                    com='a';
                }
                if(skip.contains((String.valueOf(com)))){
                    idx++;
                }
                count++;
            }
            answer+=String.valueOf(com);
        }
        
        return answer;
    }
}
