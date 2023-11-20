package Algorithm;

import java.util.*;
import java.io.*;

public class swea1984 {
	static int[] num;
	
	public static void main(String args[]) throws Exception
	{
		
		System.setIn(new FileInputStream("res/input_swea1984.txt"));
		
		
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
		
		Arrays.sort(num);
		
		
		int sum=0;
		for(int i=1;i<9;i++) {
			sum+=num[i];
		}
		
		System.out.println(Math.round(sum*1.0/8));
	}
	
	static public void input(BufferedReader br, StringTokenizer st) throws Exception{
		num = new int[10];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<10;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}
}
