package Algorithm;

import java.util.*;
import java.io.*;

public class swea1204 {
	static int[] grades;
	static int max;
	static int idx;
	
	static public void main(String args[]) throws IOException {
		
		System.setIn(new FileInputStream("res/input_swea1204.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			
			solution(br, st);
			System.out.println("#"+test_case+" "+idx);
		}
	}
	
	static public void solution(BufferedReader br, StringTokenizer st) throws IOException{
		
		grades = new int[101];
		max = Integer.MIN_VALUE;
		idx=-1;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<1000;i++) {
			int num = Integer.parseInt(st.nextToken());
			grades[num]++;
		}


		for(int i=0;i<101;i++) {
			if(max<=grades[i]) {
				idx=i;
				max=grades[i];
			}
		}
		
	}
	
}
