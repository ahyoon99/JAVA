package Algorithm;

import java.io.*;
import java.util.*;

public class G1679180 {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] result = new int[100001][6];
		for(int i=1;i<=5;i++){
			result[1][i]=1;
		}
		result[2][1]=3;
		result[2][2]=4;
		result[2][3]=3;
		result[2][4]=2;
		result[2][5]=5;
		
		for(int i=3;i<=n;i++){
			result[i][1]=(result[i-1][2]+result[i-1][3]+result[i-1][5])%100000007;
			result[i][2]=(result[i-1][1]+result[i-1][3]+result[i-1][4]+result[i-1][5])%100000007;
			result[i][3]=(result[i-1][1]+result[i-1][2]+result[i-1][5])%100000007;
			result[i][4]=(result[i-1][2]+result[i-1][5])%100000007;
			result[i][5]=(result[i-1][1]+result[i-1][2]+result[i-1][3]+result[i-1][4]+result[i-1][5])%100000007;
		}
		
		int answer = 0;
		for(int i=1;i<=5;i++){
			answer=(answer+result[n][i])%100000007;;
		}
		System.out.println(answer);
	}
}
