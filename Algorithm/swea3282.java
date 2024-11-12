package Algorithm;

import java.util.*;
import java.io.*;

public class swea3282 {
    static int t;
    static int n;
    static int k;
    static int[] volumn;
    static int[] value;

    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution();
        }
    }
    
    static void solution(){
        int[][] dp = new int[n+1][k+1];

        for(int i=0;i<=k;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(j-volumn[i]>=0){
                    dp[i][j]=Math.max(dp[i-1][j-volumn[i]]+value[i], dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        System.out.println(dp[n][k]);
    }
    
    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        volumn = new int[n+1];
        value = new int[n+1];
        

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            volumn[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

    }
}
