package Algorithm;

import java.util.*;

public class B14916 {
    // 방법 1 : Bottom up
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[100001];
        dp[2]=1;
        dp[4]=2;
        dp[5]=1;
        for(int i=6;i<=n;i++){
            if(dp[i-2]==0){
                dp[i]=dp[5]+dp[i-5];
            }
            else if(dp[i-5]==0){
                dp[i]=dp[2]+dp[i-2];
            }
            else{
                dp[i]=Math.min((dp[2]+dp[i-2]),(dp[5]+dp[i-5]));
            }
        }

        if(dp[n]==0){
            System.out.println(-1);
        }
        else{
            System.out.println(dp[n]);
        }
    }
}
