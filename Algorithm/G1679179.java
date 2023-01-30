package Algorithm;

import java.io.*;
import java.util.*;

public class G1679179 {
    static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] morningTree = new int[n][n];
		boolean[][] visited = new boolean[n][n];
				
		Queue<Pair> waitedTree1 = new LinkedList<>();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				morningTree[i][j]=sc.nextInt();
				if(morningTree[i][j]!=0){
					waitedTree1.add(new Pair(i,j));
				}
			}
		}
		
		int[][] afterTree = new int[n][n];
		for(int i=0;i<morningTree.length;i++){
			System.arraycopy(morningTree[i], 0, afterTree[i], 0, morningTree[i].length);
		}
		Queue<Pair> waitedTree2 = new LinkedList<>();
		int day=1;
		boolean isFinish = true;
		if(waitedTree1.isEmpty()){
			isFinish=false;
			day=0;
		}
		while(isFinish){
			if(waitedTree1.isEmpty() && waitedTree2.isEmpty()){
				break;
			}
			if(waitedTree1.isEmpty()){
				day++;
				
				for(int i=0;i<afterTree.length;i++){
					System.arraycopy(afterTree[i], 0, morningTree[i], 0, afterTree[i].length);
				}
				while(!waitedTree2.isEmpty()){
					Pair temp = waitedTree2.poll();
					waitedTree1.add(temp);
				}
			}
			
			Pair p = waitedTree1.poll();
			int x = p.x;
			int y = p.y;
			int cnt = 0;
			for(int i=0;i<4;i++){
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<n){
					if(morningTree[nx][ny]==0){
						cnt++;
					}
				}
			}
			if(morningTree[x][y]<=cnt){
				afterTree[x][y]=0;
			}
			else{
				afterTree[x][y]=morningTree[x][y]-cnt;
				waitedTree2.add(new Pair(x,y));
			}
		}
		System.out.println(day);
		
	}
}
