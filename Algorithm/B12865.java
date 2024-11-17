package Algorithm;

import java.util.*;
import java.io.*;

public class B12865 {
    static int answer;
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] infos = new int[n+1][2];

        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine(), " ");
            infos[i][0] = Integer.parseInt(st.nextToken());
            infos[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][k+1];
        
        for(int i=0;i<k+1;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<k+1;j++){
                if(j-infos[i][0]>=0){
                    dp[i][j]=Math.max(dp[i-1][j-infos[i][0]]+infos[i][1], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
