package Algorithm;

import java.util.*;

public class P181187 {
    
    static public void main(String args[]){
        int r1 = 2;
        int r2 = 3;
        long result = solution(r1, r2);
        System.out.println(result);
    }

    static public long solution(int r1, int r2) {
        long answer = 0;
        
        
        for(int i = 1; i <= r2; i++) {
            long n1 = (long) Math.ceil(Math.sqrt((long)r1*r1 - (long)i*i));    
            long n2 = (long) Math.floor(Math.sqrt((long)r2*r2 - (long)i*i));
            answer += (n2-n1)+1;
        }

        answer *=4;
        return answer;
    }
}
