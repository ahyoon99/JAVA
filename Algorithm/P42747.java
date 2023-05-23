package Algorithm;

import java.util.*;

public class P42747 {
    static public void main(String args[]){
        int[] citations = {3,0,6,1,5};
        int answer = solution(citations);
        System.out.println(answer);
    }

    static public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int h=-1;
        for(int i=0;i<citations.length;i++){
            h=citations.length-i;   // 논문의 개수
            if(h <= citations[i]){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}
