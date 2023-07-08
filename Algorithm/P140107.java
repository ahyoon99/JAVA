package Algorithm;

import java.util.*;

public class P140107 {
    static public void main(String args[]){
        int k = 2;
        int d = 4;

        long result = solution(k, d);
        System.out.println(result);
    }
    
    static public long solution(int k, int d) {
        long answer = 0;
        
        long dd = (long) d*d;
        
        for(long x=0; x<=d; x+=k){
            long xx = (long) x*x;
            long yy = (long) Math.sqrt(dd-xx);
            answer += yy/k;
            answer +=1;
        }
        return answer;
    }
}
