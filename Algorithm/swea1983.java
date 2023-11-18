package Algorithm;

import java.util.*;
import java.io.*;

public class swea1983 {
	
	static class Node{
		int idx;
		int score;
		
		Node(int idx, int score){
			this.idx = idx;
			this.score = score;
		}
	}
	
	static int n;
	static int k;
	static Node[] scores;
	static String[] grades = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
	
	
	public static void main(String args[]) throws Exception
	{
		
		System.setIn(new FileInputStream("res/input_swea1983.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.print("#"+test_case+" ");
			solution(br, st);
			
		}
	}
	
	static public void solution(BufferedReader br, StringTokenizer st) throws Exception{
		input(br, st);
		
		Arrays.sort(scores, (o1, o2) -> {
			return o2.score-o1.score;
		});
		
		int rank=0;
		for(int i=0;i<n;i++) {
			if(scores[i].idx==k) {
				break;
			}
			rank++;
		}
		int rankIdx = rank/(n/10);
		System.out.println(grades[rankIdx]);
		
	}
	
	static public void input(BufferedReader br, StringTokenizer st) throws Exception{
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken())-1;
		scores = new Node[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int midTest = Integer.parseInt(st.nextToken());
			int finalTest = Integer.parseInt(st.nextToken());
			int assign = Integer.parseInt(st.nextToken());
			scores[i]=new Node(i, midTest*35 + finalTest*45 + assign*20);
		}
		
	}
}

