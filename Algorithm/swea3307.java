package Algorithm;

import java.util.*;
import java.io.*;

public class swea3307 {
    static int t;
    static int n;
    static int[] num;
    static int[] dp;
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

    static void solution() {
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(num[j]<num[i] && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        num = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n];
    }
}
