package Algorithm;

import java.util.*;

public class P12938 {
    static public void main(String args[]){
        int n = 2;
        int s = 9;

        int[] result = solution(n, s);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }

    static public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(n>s){
            return new int[] {-1};
        }
        Arrays.fill(answer, s/n);
        if(s%n!=0){
            for(int i=0;i<s%n;i++){
                answer[answer.length-i-1]++;
            }
        }
        return answer;
    }
}
