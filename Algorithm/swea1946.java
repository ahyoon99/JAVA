package Algorithm;

import java.util.*;
import java.io.*;

public class swea1946 {
	static int n;
	static String answer;
	
	static public void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			System.out.println("#"+test_case+" ");
			solution(br, st);
			
		}
	}
	
	static public void solution(BufferedReader br, StringTokenizer st) throws IOException{
		input(br, st);
		
		int answerCnt = answer.length()/10;
		for(int i=0;i<answerCnt;i++) {
			System.out.println(answer.substring(i*10, i*10 + 10));
		}
		System.out.println(answer.substring(answerCnt*10, answer.length()));
	}
	
	static public void input(BufferedReader br, StringTokenizer st) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		answer="";
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String alp = st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			
			
			for(int j=0;j<cnt;j++) {
				answer+=alp;
			}
		}
	}
}

