package Algorithm;

import java.util.*;

public class P60058 {
    // 올바른 괄호 문자열인지 판별하기
    static boolean isAlright(String p){
        Stack<Integer> st = new Stack<>();
        boolean check = true;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='('){
                st.push(1);
            }
            else if(p.charAt(i)==')'){
                if(st.isEmpty()){
                    check=false;
                    break;
                }
                else{
                    st.pop();
                }
            }
        }
        return check;
    }
    
    static String go(String p){
        String answer="";
        // 1. 올바른 괄호 문자열인지 판별하기
        if(isAlright(p)){
            return p;
        }
    
        // 2. u,v 나누기
        int start = 0;
        int end = 0;
        String u = "";
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='('){
                u+="(";
                start++;
            }
            else if(p.charAt(i)==')'){
                u+=")";
                end++;
            }
            if(start==end){
                break;
            }
        }
        String v = p.substring(start+end);
        
        // 3. u가 올바른 괄호 문자열인지 확인
        if(isAlright(u)){   // 3-1. u가 올바른 괄호 문자열 일 때
            answer+=u;
            if(v.equals("")){   // 반복문 종료 조건
                return answer;
            }
            else{
                answer+=go(v);
            }
        }
        else{   // 3.2 u가 올바른 괄호 문자열이 아닐 때
            String ans = "(";
            // 3.2.1 v 수정하기
            ans+=go(v);
            ans+=")";
            
            // 3.2.2 u 수정하기
            for(int i=1;i<u.length()-1;i++){
                if(u.charAt(i)=='('){
                    ans+=")";
                }
                else if(u.charAt(i)==')'){
                    ans+="(";
                }
            }
            answer+=ans;
        }
        return answer;
    }
    
    static public String solution(String p) {
        String answer = "";
        answer = go(p);
        
        return answer;
    }

    static public void main(String args[]){
        String  p = "(()())()";
        System.out.println(solution(p));
    }
}
