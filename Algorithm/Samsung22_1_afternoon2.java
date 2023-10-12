package Algorithm;

import java.util.*;
import java.io.*;

public class Samsung22_1_afternoon2 {
    static int n;
	static int m;
	static int k;
	static int c;
	static int[][] forest;
	static int[][] kill;
	static int answer;
	
	static int[] growDx = {-1,0,1,0};
	static int[] growDy = {0,1,0,-1};
	
	static int[] killDx= {-1,1,1,-1};
	static int[] killDy= {1,1,-1,-1};
	
	static class Tree{
		Node node;
		int cnt;
		
		Tree(Node node, int cnt){
			this.node=node;
			this.cnt=cnt;
		}
	}
	
	static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static public void main(String args[]) throws IOException{
		
		input();
		
		for(int tc=0;tc<m;tc++) {
			
			grow();
			
			spread();

			afterOneYear();
			
			killTree();
		}
		
		System.out.println(answer);
		
	}
	
	
	static public void input()  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		forest = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				int num = Integer.parseInt(st.nextToken());
				forest[i][j]=num;
			}
		}
		
		kill = new int[n][n];
		answer=0;
	}
	
	static public void grow() {
		for(int x=0;x<n;x++) {
			for(int y=0;y<n;y++) {
				if(forest[x][y]<=0) {
					continue;
				}
				for(int i=0;i<4;i++) {
					int nx = x+growDx[i];
					int ny = y+growDy[i];
					if(0<= nx && nx<n&& 0<=ny && ny<n) {
						if(forest[nx][ny]>0) {
							forest[x][y]++;
						}
					}
				}
				
			}
		}
		
//		System.out.println("== grow ==");
//		System.out.println("forest");
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				if(forest[i][j]>=0 && forest[i][j]<10) {
//					System.out.print("0"+forest[i][j]+" ");
//				}
//				else {
//					System.out.print(forest[i][j]+" ");
//				}
//			}
//			System.out.println();
//		}
	}
	
	static public void spread() {
		ArrayList<Tree> trees = new ArrayList<>();
		for(int x=0;x<n;x++) {
			for(int y=0;y<n;y++) {
				int count=0;
				if(forest[x][y]<=0) {
					continue;
				}
				for(int i=0;i<4;i++) {
					int nx = x+growDx[i];
					int ny = y+growDy[i];
					if(0<= nx && nx<n&& 0<=ny && ny<n) {
						if(kill[nx][ny]>0) {
							continue;
						}
						if(forest[nx][ny]==0) {
							count++;
						}
					}
				}
				
				if(count==0) {
					continue;
				}
				int plus = forest[x][y]/count;
				for(int i=0;i<4;i++) {
					int nx = x+growDx[i];
					int ny = y+growDy[i];
					if(0<= nx && nx<n&& 0<=ny && ny<n) {
						if(kill[nx][ny]>0) {
							continue;
						}
						if(forest[nx][ny]==0) {
							trees.add(new Tree(new Node(nx, ny), plus));
						}
					}
				}
				
			}
		}
		
		for(Tree t : trees) {
			forest[t.node.x][t.node.y]+=t.cnt;
		}
		
//		System.out.println("== spread ==");
//		System.out.println("forest");
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				if(forest[i][j]>=0 && forest[i][j]<10) {
//					System.out.print("0"+forest[i][j]+" ");
//				}
//				else {
//					System.out.print(forest[i][j]+" ");
//				}
//			}
//			System.out.println();
//		}
	}
	
	static public void killTree() {
		int max = Integer.MIN_VALUE;
		int resultX=-1;
		int resultY=-1;

		//System.out.println("== calculate Tree ==");
		for(int x=0;x<n;x++) {
			for(int y=0;y<n;y++) {
				int result = calculateTree(x,y);
				if(max<result) {
					max=result;
					resultX=x;
					resultY=y;
				}
			}
		}
		
		//System.out.println("result : "+resultX+","+resultY+" : "+max);
		answer += max;
		kill[resultX][resultY]=c;
		forest[resultX][resultY]=0;
		for(int i=0;i<4;i++) {
			for(int j=1;j<=k;j++){
				int nx = resultX+j*killDx[i];
				int ny = resultY+j*killDy[i];
				if(0<= nx && nx<n && 0<=ny && ny<n) {
					if(forest[nx][ny]==-1){
						//kill[nx][ny]=c;	//
						break;
					}
					else if(forest[nx][ny]==0) {
						kill[nx][ny]=c;
						break;
					}
					else {
						forest[nx][ny]=0;
						kill[nx][ny]=c;
					}
				}
				else {
					break;
				}
			}
		}
		
//		System.out.println("== kill ==");
//		System.out.println("forest");
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				if(forest[i][j]>=0 && forest[i][j]<10) {
//					System.out.print("0"+forest[i][j]+" ");
//				}
//				else {
//					System.out.print(forest[i][j]+" ");
//				}
//			}
//			System.out.println();
//		}
//		
//		System.out.println("kill");
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				if(kill[i][j]>=0 && kill[i][j]<10) {
//					System.out.print("0"+kill[i][j]+" ");
//				}
//				else {
//					System.out.print(kill[i][j]+" ");
//				}
//			}
//			System.out.println();
//		}
	}
	
	
	
	static public int calculateTree(int x, int y) {
		
		if(forest[x][y]<=0) {
			return 0;
		}
		int cnt=forest[x][y];
		for(int i=0;i<4;i++) {
			for(int j=1;j<=k;j++){
				int nx = x+j*killDx[i];
				int ny = y+j*killDy[i];
				if(0<= nx && nx<n && 0<=ny && ny<n) {
					if(forest[nx][ny]==-1){
						break;
					}
					else if(forest[nx][ny]==0) {
						break;
					}
					else {
						cnt+=forest[nx][ny];
					}
				}
				else {
					break;
				}
			}
		}
		
		//System.out.println(x+","+y+" : "+cnt);
		return cnt;
	}
	
	static public void afterOneYear() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(kill[i][j]>0) {
					kill[i][j]--;
					
				}
			}
		}
	}
}
