package Algorithm;

import java.io.*;
import java.util.*;

public class G1681208 {
    static int n;
	static int[] num;
	static long min;
	
	public static void go(int[] result, boolean[] visited, int idx){
		if(idx>n){
			return;
		}
		if(idx==n){
			findMin(result);
			return;
		}
		
		for(int i=0;i<n;i++){
			if(visited[i]==false){
				visited[i]=true;
				result[idx]=num[i];
				go(result, visited, idx+1);
				visited[i]=false;
			}
		}	
	}
	
	public static void findMin(int[] num){
		boolean check=false;
		long result=num[0];
		for(int i=1;i<n;i++){
			long num1 = num[i-1]%10;
			long num2 = num[i]/10;
			if(num1==num2){
				result = (result*10)+num[i]%10;
				check=true;
			}
			else{
				result = result*100 + num[i];
			}
		}
		if(min==-1){
			min = result;
		}
		else if(min>result){
			min=result;
		}
		
		if(check){
			result=num[0];
			for(int i=1;i<n;i++){
				result = result*100 + num[i];
			}
			if(min==-1){
				min = result;
			}
			else if(min>result){
				min=result;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		num = new int[n];
		min=-1;
		for(int i=0;i<n;i++){
			num[i] = sc.nextInt();
		}
		
		Arrays.sort(num);
		int[] result = new int[n];
		boolean[] visited = new boolean[n];
		go(result, visited, 0);
		
		findMin(result);
		System.out.println(min);
	}
}
