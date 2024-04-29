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

        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%15746;
        }
        System.out.println(dp[n]);
    }
}