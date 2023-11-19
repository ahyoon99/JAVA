package Algorithm;

import java.util.*;
import java.io.*;

public class swea1970 {
	static int[] price = {50000,10000,5000,1000,500,100,50,10};
	static int[] priceCnt;
	static int money;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.println("#"+test_case);
			solution(br, st);
		}
	}
	
	static public void solution(BufferedReader br, StringTokenizer st) throws Exception{
		input(br, st);
		
		for(int i=0;i<price.length;i++) {
			if(money==0) {
				break;
			}
			if(money/price[i]>0) {
				priceCnt[i]=money/price[i];
				money-=price[i]*priceCnt[i];
			}
		}
		
		for(int i=0;i<8;i++) {
			System.out.print(priceCnt[i]+" ");
		}
		System.out.println();
		
	}
	
	static public void input(BufferedReader br, StringTokenizer st) throws Exception{
		priceCnt = new int[8];
		
		st = new StringTokenizer(br.readLine(), " ");
		money = Integer.parseInt(st.nextToken());
	}
}
