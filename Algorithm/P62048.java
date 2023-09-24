package Algorithm;

import java.util.*;

public class P62048 {
    static public void main(String args[]){
        int w = 8;
        int h = 12;

        long result = solution(w, h);
        System.out.println(result);
    }

    static public long solution(int w, int h) {
        long answer = 0;
        
        for(long i=1;i<=w;i++){
            long n = (i-1)*h/w;
            answer+=n;
        }
        answer*=2;
        
        return answer;
    }
}
