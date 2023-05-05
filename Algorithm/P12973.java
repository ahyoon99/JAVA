package Algorithm;

import java.util.*;

public class P12973 {
    static public void main(String args[]){
        String s = "baabaa";
        int result = solution(s);
        System.out.println(result);
    }
    static public int solution(String s)
    {
        int answer = -1;
        Stack<Character> st = new Stack<>();
        
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(st.isEmpty()){
                st.add(ch);
            }
            else if(st.peek()==ch){
                st.pop();
            }
            else{
                st.add(ch);
            }
        }
        
        answer = (st.size()==0) ? 1 : 0 ;
        
        return answer;
    }
}
