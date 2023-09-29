package Algorithm;

import java.util.*;

public class P12987 {
    static public void main(String args[]){
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        int result = solution(A, B);
        System.out.println(result);
    }
    
    static public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idxA = A.length-1;
        int idxB = B.length-1;
        while(idxA>=0){
            if(A[idxA]<B[idxB]){
                answer++;
                idxA--;
                idxB--;
            }
            else{
                idxA--;
            }
        }
        
        return answer;
    }
}
