package Algorithm;

import java.util.*;

public class P81301 {

    static public int solution(String s) {
        int answer = 0;
        
        String result = "";
        int idx = 0;
        while(idx < s.length()){
            if('0'<= s.charAt(idx) && s.charAt(idx) <= '9'){
                result+=String.valueOf(s.charAt(idx));
                idx++;
            }
            else if(s.charAt(idx) == 'z'){
                result += "0";
                idx += 4;
            }
            else if(s.charAt(idx) == 'o'){
                result += "1";
                idx += 3;
            }
            else if(s.charAt(idx) == 't' && s.charAt(idx+1) == 'w'){
                result +="2";
                idx += 3;
            }
            else if(s.charAt(idx) == 't' && s.charAt(idx+1) == 'h'){
                result += "3";
                idx +=5;
            }
            else if(s.charAt(idx) == 'f' && s.charAt(idx+1) == 'o'){
                result += "4";
                idx+=4;
            }
            else if(s.charAt(idx) == 'f' && s.charAt(idx+1) == 'i'){
                result += "5";
                idx+=4;
            }
            else if(s.charAt(idx) == 's' && s.charAt(idx+1) == 'i'){
                result += "6";
                idx+=3;
            }
            else if(s.charAt(idx) == 's' && s.charAt(idx+1) == 'e'){
                result += "7";
                idx+=5;
            }
            else if(s.charAt(idx) == 'e'){
                result += "8";
                idx += 5;
            }
            else if(s.charAt(idx) == 'n'){
                result += "9";
                idx += 4;
            }
        }
        answer = Integer.parseInt(result);
        return answer;
    }
    static public void main(String args[]){
        String s = "one4seveneight";
        solution(s);
    }
}
