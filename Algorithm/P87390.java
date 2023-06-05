package Algorithm;

import java.util.*;

public class P87390 {
    static public void main(String args[]){
        int n = 3;
        long left = 2;
        long right = 5;

        int[] result = solution(n, left, right);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
    
    static public int[] solution(int n, long left, long right) {
        int size = (int) right - (int) left;
        int[] answer = new int[size+1];
        
        int idx=0;
        for(long i = left;i<=right;i++,idx++){
            long row = i/n;
            long column = i%n;
            answer[idx] = Math.max((int)row, (int)column)+1;
        }
        return answer;
    }
}
