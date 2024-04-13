package Algorithm;

import java.util.*;
import java.io.*;

public class B1562 {
    static final int MOD = 1000000000;
    static int n;
    static int[][][] dp;
    static public void main(String args[]) throws IOException{
        input();

        solution();
    }

    static void solution(){
        if(n<10){
            System.out.println(0);
            return;
        }

        for(int i=1;i<10;i++){
            dp[1][i][1<<i]=1;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                for(int k=0;k<(1<<10);k++){    // (1 << 10) == 1024
                    int newBit = k | (1<<j);
                    if(j==0){
                        dp[i][j][newBit] = (dp[i][j][newBit] + dp[i-1][j+1][k]) % MOD;
                    }
                    else if(j==9){
                        dp[i][j][newBit] = (dp[i][j][newBit] + dp[i-1][j-1][k]) % MOD;
                    }
                    else{
                        dp[i][j][newBit] = (dp[i][j][newBit] + dp[i-1][j-1][k] + dp[i-1][j+1][k]) % MOD;
                    }
                }
            }
        }

        long result = 0;
        for(int i=0;i<10;i++){
            result = (result + dp[n][i][1023]) % MOD;
        }
        System.out.println(result);
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        dp = new int[n+1][10][1024];    // (1 << 10) == 1024
    }
}
