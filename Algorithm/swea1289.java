package Algorithm;

import java.util.*;
import java.io.*;

public class swea1289 {
	static int t;
	static int[] numbers;
	static int val;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");		
		t = Integer.parseInt(st.nextToken());

		for(int testcase=1;testcase<=t;testcase++) {
			System.out.print("#"+testcase+" ");
			input(br, st);
			solution();
		}
	}
	
	static void solution() {
		for(int i=0;i<numbers.length;i++) {
			if(val!=numbers[i]) {
				if(numbers[i]==0) {
					val=0;
				}
				else {
					val=1;
				}
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		String str = st.nextToken();
		
		numbers = new int[str.length()];
		
		for(int i=0;i<str.length();i++) {
			numbers[i]=str.charAt(i)-'0';
		}
		
		val = 0;
		answer = 0;
	}
}

