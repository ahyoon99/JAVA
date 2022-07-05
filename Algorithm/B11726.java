package Algorithm;

import java.util.*;

public class B11726 {
    
    // static int go(int n, int[] answer){
    //     if(answer[n]>0){
    //         return answer[n];
    //     }
    //     if(answer[n]<=0){
    //         answer[n]= (go(n-1,answer) + go(n-2,answer)) % 10007; 
    //     }
    //     return answer[n];
    // }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] answer = new int[1001];
        answer[1]=1;
        answer[2]=2;

        // 1. Top-down (재귀)
        // System.out.println(go(n, answer));

        // 2. Bottom-up (for문)
        for(int i=3;i<=n;i++){
            answer[i] = (answer[i-1]+answer[i-2]) % 10007;
        }
        System.out.println(answer[n]);
    }
    
}
