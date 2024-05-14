package Algorithm;

import java.util.*;
import java.io.*;

public class swea2001 {
    static int t;
	static int n;
	static int m;
	static int[][] matrix;
	static int max;
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		t = Integer.parseInt(st.nextToken());
		
		for(int testcase=1;testcase<=t;testcase++) {
			System.out.print("#"+testcase+" ");
			solution(br, st);
			System.out.println(max);
		}
	}
	
	static void solution(BufferedReader br, StringTokenizer st) throws IOException{
		input(br, st);
		
		for(int i=0;i<=(n-m);i++) {
			for(int j=0;j<=(n-m);j++) {
				int temp=0;
				for(int k1=0;k1<m;k1++) {
					for(int k2=0;k2<m;k2++) {
						temp+=matrix[i+k1][j+k2];
					}
				}
				max = Math.max(max, temp);
			}
		}
	}
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		matrix = new int[n][n];
		
		max = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				matrix[i][j]=Integer.parseInt(st.nextToken());
			}
		}
	}
}
