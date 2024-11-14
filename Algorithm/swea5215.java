package Algorithm;

import java.util.*;
import java.io.*;

public class swea5215 {
    static int t;
	static int n;
	static int l;
	static int[] flavor;
	static int[] cal;
	static int result;
	
	static public void main(String args[]) throws IOException{

		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		t = Integer.parseInt(st.nextToken());
		
		for(int testcase=1;testcase<=t;testcase++) {
			System.out.print("#"+testcase+" ");
			input(br, st);
			// 방법 1
			//solution();

			// 방법 2
			solution2();
		}
	}
	
	static void solution() {
		for(int i=1;i<=n;i++) {
			go(i,0,0,0);
		}
		System.out.println(result);
	}
	
	static void go(int length, int idx, int flaSum, int calSum) {
		if(idx>=length) {
			if(calSum<=l) {
				result = Math.max(result, flaSum);
			}
			return;
		}
		go(length, idx+1, flaSum+flavor[idx], calSum+cal[idx]);
		go(length, idx+1, flaSum, calSum);
	}
	
	static void solution2(){
        int[][] dp = new int[n+1][l+1];

        for(int i=0;i<=l;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=l;j++){
                if(j-cal[i-1]>=0){
                    dp[i][j] = Math.max(dp[i-1][j-cal[i-1]]+flavor[i-1], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][l]);
    }

	static void input(BufferedReader br, StringTokenizer st) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		flavor = new int[n];
		cal = new int[n];
		result = 0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			flavor[i]=Integer.parseInt(st.nextToken());
			cal[i] = Integer.parseInt(st.nextToken());
		}
	}
}
