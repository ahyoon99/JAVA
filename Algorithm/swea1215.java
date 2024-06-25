package Algorithm;

import java.util.*;
import java.io.*;

public class swea1215 {
	static int length;
	static char[][] matrix;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int testcase=1;testcase<=10;testcase++) {
			System.out.print("#"+testcase+" ");
			input(br);
			solution();	
		}
	}
	
	static void solution() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<=8-length;j++) {
				String med = "";
				for(int k=0;k<length;k++) {
					med+=String.valueOf(matrix[i][j+k]);
				}
				if(isPalindrome(med)) {
					answer++;
				}
			}
		}
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<=8-length;j++) {
				String med = "";
				for(int k=0;k<length;k++) {
					med+=String.valueOf(matrix[j+k][i]);
				}
				if(isPalindrome(med)) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean isPalindrome(String str) {
		
		for(int i=0;i<str.length()/2;i++) {
			if(str.charAt(i)!=str.charAt(str.length()-i-1)) {
				return false;
			}
		}
		return true;
	}
	
	
	static void input(BufferedReader br) throws IOException{
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		length = Integer.parseInt(st.nextToken());
		
		matrix = new char[8][8];
		answer = 0;
		
		for(int i=0;i<8;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			matrix[i] = st.nextToken().toCharArray();
		}
	}
}

