package Algorithm;

import java.util.*;

public class P12971 {
    static public void main(String args[]){
        int sticker[] = {14,6,5,11,3,9,2,10};
        int result = solution(sticker);
        System.out.println(result);
    }

    static public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
    
        if(n==1){
            return sticker[0];
        }
        
        int[] dp = new int[n];
        
        // 1. 첫번째 스티커 뜯을 때
        dp[0]=sticker[0];
        dp[1]=dp[0];
        
        for(int i=2;i<n-1;i++){
            dp[i]=Math.max(dp[i-2]+sticker[i], dp[i-1]);
        }
        
        Arrays.sort(dp);
        answer = dp[n-1];
        
        
        // 1. 첫번째 스티커 안 뜯을 때
        dp[0]=0;
        dp[1]=sticker[1];
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+sticker[i], dp[i-1]);
        }
        
        Arrays.sort(dp);
        answer = Math.max(answer, dp[n-1]);
        

        return answer;
    }
}
