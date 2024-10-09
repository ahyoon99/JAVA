package Algorithm;

import java.util.*;
import java.io.*;

public class B15989 {
    static int tc;
    static int n;
    static int[][] dp;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        tc = Integer.parseInt(st.nextToken());

        dp = new int[10001][4];
        
        dp[1][1]=1;
        dp[2][1]=1;
        dp[2][2]=1;
        dp[3][1]=1;
        dp[3][2]=1;
        dp[3][3]=1;
            
        for(int i=4;i<dp.length;i++){
            dp[i][1]+=dp[i-1][1];

            for(int j=1;j<=2;j++){
                dp[i][2] += dp[i-2][j];
            }

            for(int j=1;j<=3;j++){
                dp[i][3] += dp[i-3][j];
            }
        }

        for(int testcase=0;testcase<tc;testcase++){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());

            int answer = dp[n][1]+dp[n][2]+dp[n][3];
            System.out.println(answer);
        }
    }
}
