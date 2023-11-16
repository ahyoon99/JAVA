package Algorithm;

import java.util.*;
import java.io.*;

public class swea1859 {
	static int n;
	static int[] num;
	static int max;
	static long answer;
	
	static public void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			solution(br, st);
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
	static public void solution(BufferedReader br, StringTokenizer st) throws IOException{
		input(br, st);
		
		
		for(int i=0;i<n;i++) {
			if(max<num[i]) {
				max=num[i];
			}
			answer+=(max-num[i]);
		}
	}
	
	static public void input(BufferedReader br, StringTokenizer st) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		num = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=n-1;i>=0;i--) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		max=Integer.MIN_VALUE;
		answer=0;
	}

}

