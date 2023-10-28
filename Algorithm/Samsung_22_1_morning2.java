package Algorithm;

import java.util.*;
import java.io.*;

public class Samsung_22_1_morning2 {
	
	static int[][] board;
	static int n;
	static int[][] group;
	static HashMap<Integer, Info> information;
	static int[][] edges;
	static int answer;
	
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	
	static class Info{
		int size;
		int num;
		
		Info(int size, int num){
			this.size = size;
			this.num = num;
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
		
		beautiful();
		
		for(int i=0;i<3;i++) {
			rotate();
			beautiful();
		}
		
		System.out.println(answer);
	}
	
	static public void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		board = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		 answer=0;
	}
	
	static public void beautiful() {
		group = new int[n][n];
		information = new HashMap<Integer, Info>();
		boolean[][] visited = new boolean[n][n];
		int num=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int cnt = bfs(num, i, j, visited);
				if(cnt!=-1) {
					information.put(num, new Info(cnt, board[i][j]));
					num++;
				}
			}
		}
		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++){
//				System.out.print(group[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
//		for(Map.Entry<Integer, Info> entry : information.entrySet()) {
//			System.out.println(entry.getKey()+" : "+entry.getValue().size+" , "+entry.getValue().num);
//		}
		

		edges = new int[num][num];
		calEdge();
		
		
		answer += calculate();
		
	}
	
	static public int bfs(int num, int x, int y, boolean[][] visited) {
		if(visited[x][y]==true) {
			return -1;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		visited[x][y]=true;
		group[x][y]=num;
		int cnt=1;
		while(!q.isEmpty()) {
			Node node = q.poll();
			x=node.x;
			y=node.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(!isRangeOf(nx, ny)) {
					continue;
				}
				if(board[nx][ny]==board[x][y] && visited[nx][ny]==false) {
					q.add(new Node(nx, ny));
					visited[nx][ny]=true;
					group[nx][ny]=num;
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	static public void calEdge() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<4;k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(!isRangeOf(nx, ny)) {
						continue;
					}
					if(group[nx][ny]==group[i][j]) {
						continue;
					}
					edges[group[i][j]][group[nx][ny]]++;
					edges[group[nx][ny]][group[i][j]]++;
				}
			}
		}
		
//		System.out.println("egdes");
//		for(int i=0;i<edges.length;i++) {
//			for(int j=0;j<edges[i].length;j++) {
//
//				System.out.print(edges[i][j]+" ");
//			}
//			System.out.println();
//		}
	}

	
	static public boolean isRangeOf(int x, int y) {
		if(0<= x && x<n && 0<= y && y<n) {
			return true;
		}
		else {
			return false;
		}
	}
	
	static public int calculate() {
		int total = information.size();
		int totalScore = 0;
		for(int i=1;i<total;i++) {
			for(int j=i+1;j<=total;j++) {
				int score = (information.get(i).size + information.get(j).size)*information.get(i).num*information.get(j).num*(edges[i][j]/2);
				totalScore+=score;
				
			}
		}
		return totalScore;
	}
	
	
	
	
	static public void rotate() {

		int length = n/2;
		int[] rotateDx = {0,0,length+1,length+1};
		int[] rotateDy = {0,length+1,0,length+1};
		
		int[][] before = new int[length][length];
		int[][] after = new int[length][length];
		int startX=0;
		int startY=0;
		
		
		
		for(int i=0;i<4;i++) {
			startX=rotateDx[i];
			startY=rotateDy[i];
			
			for(int j=0;j<length;j++) {
				for(int k=0;k<length;k++) {
					before[j][k]=board[j+startX][k+startY];
					board[j+startX][k+startY]=0;
				}
			}
			
			for(int j=0;j<length;j++) {
				for(int k=0;k<length;k++) {
					after[k][length-j-1]=before[j][k];
				}
			}
			
			for(int j=0;j<length;j++) {
				for(int k=0;k<length;k++) {
					board[j+startX][k+startY]=after[j][k];
				}
			}
			
		}
		
		
		after = new int[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(after[i], -1);;
		}
		for(int i=0;i<n;i++) {
			after[n-n/2-1][i]=board[i][n/2];
			after[n-i-1][n/2]=board[n/2][i];
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(after[i][j]==-1) {
					continue;
				}
				board[i][j]=after[i][j];
			}
		}
		
//		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(board[i][j]+" ");
//			}
//			System.out.println();
//		}
	}
}

/*
5
1 2 1 1 2
3 4 1 3 4
2 2 3 4 4
1 2 5 1 2
3 4 5 3 4

 */
