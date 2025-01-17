package Algorithm;

import java.util.*;
import java.io.*;

public class swea1486 {
	static int tc;
	static int n;
	static int b;
	static int[] height;
	static int result;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		tc = Integer.parseInt(st.nextToken());
		
		for(int testcase=1;testcase<=tc;testcase++) {
			System.out.print("#"+testcase+" ");
			input(br, st);
			solution();
			System.out.println(result);
		}
		
	}
	
	static void solution() {
		for(int i=1;i<=n;i++) {
			int[] order = new int[i];
			go(order, 0, 0);
		}
	}
	
	static void go(int[] order, int orderIdx, int heightIdx) {
		if(orderIdx>=order.length) {
			int total=0;
			for(int i=0;i<order.length;i++) {
				total+=order[i];
			}
			if(total>=b) {
				result = Math.min(result, total-b);
			}
			return;
		}
		
		if(heightIdx>=n) {
			return;
		}
		
		order[orderIdx]=height[heightIdx];
		go(order, orderIdx+1, heightIdx+1);
		order[orderIdx]=0;
		go(order, orderIdx, heightIdx+1);
		
	}
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		height = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(height);
		
		result = Integer.MAX_VALUE;
	}
}

