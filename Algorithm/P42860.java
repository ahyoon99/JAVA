package Algorithm;

import java.util.*;

public class P42860 {
    static public void main(String args[]){
        String name = "JAN";

        int result = solution(name);
        System.out.println(result);
    }

    static public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        
        for(int i=0;i<name.length();i++){
            if(name.charAt(i)!='A'){
                answer += Math.min(name.charAt(i)-'A', 26-name.charAt(i)+'A');
            }
            int next=i+1;
            while(next<name.length() && name.charAt(next)=='A'){
                next++;
            }
            
            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            move = Math.min(move, i*2 + name.length() - next);
            
            // BBBBAAAAAAAB와 같이 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우도 고려
            move = Math.min(move, (name.length() - next)*2 + i);
        }
        return answer+move;
    }
    
}
