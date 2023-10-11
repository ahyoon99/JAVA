package Algorithm;

import java.util.*;

public class G33428 {

    static int MOD = 100000007;
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][][] dp = new int[n+1][n+1][2];

        boolean[][][] visited = new boolean[n+1][n+1][2];

        dp[n][0][0]=1;
        visited[n][0][0]=true;

        for(int i=n;i>=0;i--){
            for(int j=n;j>=0;j--){
                for(int k=0;k<2;k++){
                    if(!visited[i][j][k]){
                        continue;
                    }
                    if(i!=0){
                        dp[i-1][j+1][1] += dp[i][j][k];
                        dp[i-1][j+1][1] %= MOD;
                        visited[i-1][j+1][1]=true;
                    }
                    if(j!=0){
                        dp[i][j-1][0] += dp[i][j][k] * (j-k);
                        dp[i][j-1][0] %= MOD;
                        visited[i][j-1][0]=true;
                    }
                }
            }
        }
        System.out.println(dp[0][0][0]);
    }
}
