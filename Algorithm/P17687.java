package Algorithm;

import java.util.*;

public class P17687 {
    static public void main(String args[]){
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 1;

        String result = solution(n, t, m, p);
        System.out.println(result);
    }
    
    static public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String total = "";
        int idx=0;
        while(total.length()<m*t){
            total+=Integer.toString(idx,n);
            idx++;
        }
        
        for(int i=0;i<t;i++){
            answer+=String.valueOf(total.charAt(i*m+(p-1)));
        }
        
        answer = answer.toUpperCase();
        return answer;
    }
}
