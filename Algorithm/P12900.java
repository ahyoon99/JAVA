package Algorithm;

import java.util.*;

public class P12900 {
    static public void main(String args[]){
        int n = 4;

        int result = solution(n);
        System.out.println(result);
    }

    static public int solution(int n) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        
        // 방법 1 : DP (Bottom up)
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-2]+dp[i-1])%1000000007;
        }
        answer = dp[n];
        
        // 방법 2 : DP (Top down)
        // answer = go(dp, n);
        
        return answer;
    }
    
    // static public int go(int[] dp, int n){
    //     if(n==1){
    //         dp[1]=1;
    //         return dp[1];
    //     }
    //     if(n==2){
    //         dp[2]=2;
    //         return dp[2];
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     else{
    //         dp[n]=(go(dp, n-1)+go(dp, n-2))%1000000007;
    //     }
        
    //     return dp[n];
    // }
}
