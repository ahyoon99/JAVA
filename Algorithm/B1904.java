package Algorithm;

import java.util.*;
import java.io.*;

public class B1904 {
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());

        if(n==1){
            System.out.println(1);
            return;
        }

        int[] dp = new int[n+1];

        // 방법 1. Bottom up
        // dp[1]=1;
        // dp[2]=2;

        // for(int i=3;i<=n;i++){
        //     dp[i]=(dp[i-1]+dp[i-2])%15746;
        // }
        // System.out.println(dp[n]);

        // 방법 2. Top down
        int result = go(n, dp);
        System.out.println(result);
        
    }

    static int go(int n, int[] dp){
        if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        if(dp[n]==0){
            dp[n] = (go(n-1, dp)+go(n-2, dp))%15746;
        }
        return dp[n];
    }
}
