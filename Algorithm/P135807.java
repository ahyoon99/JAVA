package Algorithm;

import java.util.*;

public class P135807 {
    static public void main(String args[]){
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};

        int result = solution(arrayA, arrayB);
        System.out.println(result);
    }

    static public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int numA = arrayA[0];
        for(int i=1;i<arrayA.length;i++){
            numA = gcd(numA, arrayA[i]);
        }
        
        int numB = arrayB[0];
        for(int i=1;i<arrayB.length;i++){
            numB = gcd(numB, arrayB[i]);
        }
        
        boolean check=true;
        for(int i=0;i<arrayA.length;i++){
            if(arrayA[i]%numB==0){
                check=false;
                break;
            }
        }
        if(check){
            answer=numB;
        }
        
        check=true;
        for(int i=0;i<arrayB.length;i++){
            if(arrayB[i]%numA==0){
                check=false;
                break;
            }
        }
        if(check && answer<numA){
            answer=numA;
        }
        return answer;
    }
    
    
    static public int gcd(int a, int b){
        if(a%b==0){
            return b;
        }    
        return gcd(b, a%b);
    }
}
