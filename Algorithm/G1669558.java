package Algorithm;

import java.io.*;
import java.util.*;

public class G1669558 {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		int[][] bomb = new int[n][n];
		for(int i=0;i<n;i++){
			Arrays.fill(bomb[i],0);
		}
		
		for(int i=0;i<k;i++){
			int x = sc.nextInt() -1;
			int y = sc.nextInt() -1;
			bomb[x][y]++;
			for(int j=0;j<4;j++){
				int nx = x+dx[j];
				int ny = y+dy[j];
				if(0<=nx && nx<n&& 0<=ny && ny<n){
					bomb[nx][ny]++;
				}
			}
		}
		int total=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				total+=bomb[i][j];
			}
		}
		System.out.println(total);
	}

}
