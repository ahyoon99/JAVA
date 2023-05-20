package Algorithm;

import java.util.*;

public class P76502 {
    static public void main(String args[]){
        String s = "[](){}";

        int result = solution(s);
        System.out.println(result);
    }
    static public int solution(String s) {
        int answer = 0;
        
        for(int i=0;i<s.length();i++){
            String temp="";
            for(int j=i;j<i+s.length();j++){
                temp+=s.charAt(j%s.length());
            }
            
            if(isValid(temp)){
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isValid(String s){
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(1);
            }
            else if(s.charAt(i)=='['){
                st.push(2);
            }
            else if(s.charAt(i)=='{'){
                st.push(3);
            }
            else if(!st.isEmpty()){
                if(s.charAt(i)==')' && st.peek()==1){
                    st.pop();
                }
                else if(s.charAt(i)==']' && st.peek()==2){
                    st.pop();
                }
                else if(s.charAt(i)=='}' && st.peek()==3){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}
